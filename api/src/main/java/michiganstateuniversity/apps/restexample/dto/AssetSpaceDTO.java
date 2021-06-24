package michiganstateuniversity.apps.restexample.dto;

public class AssetSpaceDTO
{
    private int syscode;
    private String spaceNumber;
    private String floorCode;

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
     * @return the spaceNumber
     */
    public String getSpaceNumber() {
        return spaceNumber;
    }

    /**
     * @param aSpaceNumber the spaceNumber to set
     */
    public void setSpaceNumber(final String aSpaceNumber) {
        spaceNumber = aSpaceNumber;
    }

    /**
     * @return the FloorCode
     */
    public String getFloorCode() {
        return floorCode;
    }

    /**
     * @param aFloorCode the FloorCode to set
     */
    public void setFloorCode(final String aFloorCode) {
        floorCode = aFloorCode;
    }

}