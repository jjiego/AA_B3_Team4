# AA_B3_Team4

## 1. origin Class Diagram

![origin](./img/OriginalClassDiagram.png)

## 2. Big change from origin Project
### 2.1 change VRUI
```java
	public static void main(String[] args) {
		mng = MainController.getInstance();
		System.out.println("do");
		while(mng.isRun()){
			mng.showCommand();
			mng.getCommand();
			mng.doCommand();
		}
	}
```
### 2.2 make function list and do command with command idx
```java
    public abstract class IFunction {
        String name;
        public String funcName() {
            return name;
        }
        public abstract boolean run();
    }
     private List<IFunction> func;
     private void setFunction(){
        func.add(new F_Quit());
        func.add(new F_CustomerList());
        func.add(new F_VideoList());
        func.add(new F_CustomerRegister(scanner));
        func.add(new F_VideoRegister(scanner));
        func.add(new F_VideoRent(scanner));
        func.add(new F_VideoReturn(scanner));
        func.add(new F_ShowCustomerReport(scanner));
        func.add(new F_ShowNClearRent(scanner));

    }
    public void doCommand(){
        quit = func.get(command).run();
    }
```
### 2.3 make Managers with SingleTon
#### 2.3.1 CustomerManager.java
```java
public class CustomerManager {
    private static CustomerManager cMng = null;
    private List<CustomerVO> customers;

    private CustomerManager() {
        customers = new ArrayList<CustomerVO>();
    }

    public static CustomerManager getInstance() {
        if (cMng == null) cMng = new CustomerManager();
        return cMng;
    }
 }
```
#### 2.3.2 HistoryManager.java
```java
public class HistoryManager {
    private static HistoryManager hMng = null;
    private List<RentalVO> History;

    private HistoryManager() {
        History = new ArrayList<>();
    }

    public static HistoryManager getInstance() {
        if (hMng == null) hMng = new HistoryManager();
        return hMng;
    }
```
#### 2.3.3 RentalManager.java
```java
 public class RentalManager {
    private static RentalManager rMng = null;
    private List<RentalVO> rentalList;
    private List<RentalVO> CustomerRental;

    private RentalManager() {
        rentalList = new ArrayList<RentalVO>();
    }

    public static RentalManager getInstance() {
        if (rMng == null) rMng = new RentalManager();
        return rMng;
    }
 }
```
#### 2.3.3 VideoManager.java
```java
 public class VideoManager {
    private static VideoManager vMng = null;
    private List<VideoVO> videoList;


    private VideoManager() {
        videoList = new ArrayList<>();
    }

    public static VideoManager getInstance() {
        if (vMng == null) vMng = new VideoManager();
        return vMng;
    }
 }
 ```
### 2.4 seperate function in reporting method
``` java
        public void showHistory(String customerName) {
            int totalCharge = 0;
            int totalPoint = 0;
            int nowCharge;
            int nowPoint;
            List<RentalVO> hitsory = HistoryManager.getInstance().getRentalHistory(customerName);

            for (RentalVO rental : hitsory) {
                nowCharge = rental.getCharge();
                totalCharge += nowCharge;
                nowPoint = rental.getPoint();
                totalPoint += nowPoint;

                System.out.println(
                        "\t" + rental.getVideo().getTitle()
                                + "\tDays rented: " + rental.getDaysRented()
                                + "\tCharge: " + nowCharge
                                + "\tPoint: " + nowPoint + "\n");
            }
            System.out.println(
                    "Total charge: " + totalCharge
                            + "\tTotal Point:" + totalPoint + "\n"
            );
            if (totalPoint >= 10) {
                System.out.println("Congrat! You earned one free coupon");
            }
            if (totalPoint >= 30) {
                System.out.println("Congrat! You earned two free coupon");
            }
        }
```
### 2.5 make duplicate method in one method
#### 2.5.1 RentalVO.java
``` java
    public int getDaysRented(){
        if(status) return calcRentedDay(new Date());
        return daysRented;

    }
    private int calcRentedDay(Date Compare){
        long diff = Compare.getTime() - rentDate.getTime();
        return (int) (diff / (1000 * 60 * 60 * 24)) + 1;
    }
```
#### 2.5.2 VideoVO.java
```java
    public String getInform(){
        return "\tTitle : "+title+"\t Price"+priceCode;
    }
 ```
#### 2.5.2 IFountThings.java
```java
    public boolean getCustomer(){
        System.out.println("Enter customer name: ") ;
        String customerName = scanner.next() ;
        customer = CustomerManager.getInstance().getCustomer(customerName);
        if(customer==null){
            System.out.println("No customer found");
            return false;
        }
        return true;
    }
    public boolean getVideo(){
        String videoTitle = getVideoTitle();
        VideoVO video = VideoManager.getInstance().getAbleVideo(videoTitle);
        if(video == null) return false;
        return true;
    }
    public String getVideoTitle(){
        System.out.println("Enter video title to rent: ") ;
        return scanner.next();
    }
 ```
### 2.6 Store data, for use (not calculate it in RT)
#### 2.6.1 RentalVO.java
```java
    public RentalVO(String customerName, VideoVO video){
        this.customerName = customerName;
        this.video = video;
        rentDate = new Date();
        status = true;
        video.setRented(true);
        daysRented = 0;
    }
        public void returnVideo(){
        if(status) {
            returnDate = new Date();
            status = false;
            video.setRented(false);
            daysRented = calcRentedDay(returnDate);
            charge = calcCharge(daysRented);
        }
    }
```
#### 2.6.2 VideoManager.java
```java
    public void add(String title, int videoType, int priceCode){
        VIDEO_TYPE eVideoType = getVideoType(videoType);
        PRICE_CODE_TYPE ePriceCode = getPriceType(priceCode);
        int limit = getLimit(eVideoType);

        VideoVO video = new VideoVO(title, eVideoType, ePriceCode, limit) ;

        videoList.add(video) ;
    }
    private int getLimit(VIDEO_TYPE videoType){
        switch (videoType){
            case VHS: return 5;
            case CD: return 3;
            case DVD: return 2;
            default : return 0;
        }
    }
    public VIDEO_TYPE getVideoType(int type){
        switch(type){
            case 1: return VIDEO_TYPE.VHS;
            case 2: return VIDEO_TYPE.CD;
            case 3: return VIDEO_TYPE.DVD;
        }
        return VIDEO_TYPE.NONE;
    }
    public PRICE_CODE_TYPE getPriceType(int type){
        if(type==1) return PRICE_CODE_TYPE.REGULAR;
        return PRICE_CODE_TYPE.NEW_RELEASE;
    }
```
#### 2.6.3 VideoVO.java
```java
    public VideoVO(String title, VIDEO_TYPE videoType, PRICE_CODE_TYPE priceCode, int limit){
        this.title = title;
        this.videoType = videoType;
        this.priceCode = priceCode;
        this.registeredDate = new Date();
        rented = false;
        setPenallty();
        this.limit = limit;
    }
    private void setPenallty(){
        switch ( videoType ) {
            case VHS: penallty = 1 ; break ;
            case CD: penallty = 2 ; break ;
            case DVD: penallty = 3 ; break ;
            default: penallty = 0;
        }
    }
```
## 3. Refactoring Class Diagram
![Refactoring](./img/ClassDiagram.png)

## 4. Refactoring Examples

### 4.1 Initial Creations
![Create](./img/Sequence_init.PNG)

### 4.2 Rent Flow
![Rent](./img/Sequence_Rent.PNG)

## 5. Metrics

### 5.1 Origin
![origin_Metric](https://user-images.githubusercontent.com/46041410/178705898-5deb3d8a-1593-4f0c-86f6-bcad016ffc7c.png)

### 5.2. Refactoring

![refact_Metric](https://user-images.githubusercontent.com/46041410/178705654-768785d9-d39e-4103-829b-ce6b724bb00b.png)

