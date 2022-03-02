package cis.bo;

/**
 * Sale class will hold information about sales.
 * @author BJ
 * @since 20150302
 */
public class Sale {
    private String dateOfSale;
    private double soldPrice;
    private int vehicleId;
    private String salesPersonName;

    /**
     * Parameterized custom constructor to create a sale.
     *
     * @since 20170228
     * @author CIS1232

     * @param dateOfSale
     * @param soldPrice
     * @param vehicleId
     * @param salesPersonName 
     */
    public Sale(String dateOfSale, double soldPrice, int vehicleId, String salesPersonName) {
        this.dateOfSale = dateOfSale;
        this.soldPrice = soldPrice;
        this.vehicleId = vehicleId;
        this.salesPersonName = salesPersonName;
    }

    @Override
    public String toString() {
        return "Sale{" + "dateOfSale=" + dateOfSale + ", soldPrice=" + soldPrice + ", vehicleId=" + vehicleId + ", salesPersonName=" + salesPersonName + '}';
    }

    public String getDateOfSale() {
        return dateOfSale;
    }

    public void setDateOfSale(String dateOfSale) {
        this.dateOfSale = dateOfSale;
    }

    public double getSoldPrice() {
        return soldPrice;
    }

    public void setSoldPrice(double soldPrice) {
        this.soldPrice = soldPrice;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getSalesPersonName() {
        return salesPersonName;
    }

    public void setSalesPersonName(String salesPersonName) {
        this.salesPersonName = salesPersonName;
    }
    
    
}
