package cis.bo.base;

/**
 * Define methods needed for reserving and releasing
 * @author bjmac
 * @since 20210324
 */
public interface Reservable {
    
    //constants
    
    //abstract methods
    public abstract void reserve();
    public void release();
    
}
