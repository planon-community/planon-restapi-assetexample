package michiganstateuniversity.apps.restexample.dto;

public class AssetPropertyDTO
{
    private int syscode;
    private String propertyCode;
    private String commonName;
    private String status;

    /**
     * @return the syscode
     */
    public int getSyscode() {
        return syscode;
    }

    /**
     * @param aPropertySyscode the syscode to set
     */
    public void setSyscode(final int aSyscode) {
        syscode = aSyscode;
    }

    /**
     * @return the propertyCode
     */
    public String getPropertyCode() {
        return propertyCode;
    }

    /**
     * @param aPropertyCode the PropertyCode to set
     */
    public void setPropertyCode(final String aPropertyCode) {
        propertyCode = aPropertyCode;
    }

    /**
     * @return the commonName
     */
    public String getCommonName() {
        return commonName;
    }

    /**
     * @param aCommonName the commonName to set
     */
    public void setCommonName(final String aCommonName) {
        commonName = aCommonName;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param aStatus the status to set
     */
    public void setStatus(final String aStatus) {
        status = aStatus;
    }

}
