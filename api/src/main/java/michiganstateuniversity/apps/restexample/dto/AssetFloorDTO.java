package michiganstateuniversity.apps.restexample.dto;

public class AssetFloorDTO
{
    private int syscode;
    private String floorCode;
    private String name;
    private String propertyCode;

    /**
     * @return the syscode
     */
    public int getSyscode() {
        return syscode;
    }

    /**
     * @param aPersonSyscode the syscode to set
     */
    public void setSyscode(final int aSyscode) {
        syscode = aSyscode;
    }

    /**
     * @return the floorCode
     */
    public String getFloorCode() {
        return floorCode;
    }

    /**
     * @param aFloorCode the floorCode to set
     */
    public void setFloorCode(final String aFloorCode) {
        floorCode = aFloorCode;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param aName the Name to set
     */
    public void setName(final String aName) {
        name = aName;
    }

    /**
     * @return the Property Code
     */
    public String getPropertyCode() {
        return propertyCode;
    }

    /**
     * @param aPropertyCode the Property Code to set
     */
    public void setPropertyCode(final String aPropertyCode) {
        propertyCode = aPropertyCode;
    }

}