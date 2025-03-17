package LLD.CarRentalSystem.finall;

public class Customer {
    private String name;
    private String mobileNo;
    private String licenseNo;

    public Customer(String name, String mobileNo, String licenseNo) {
        this.name = name;
        this.mobileNo = mobileNo;
        this.licenseNo = licenseNo;
    }

    public String getName() {
        return name;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public String getLicenseNo() {
        return licenseNo;
    }
}
