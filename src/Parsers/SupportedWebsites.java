package Parsers;

public enum SupportedWebsites {
    ALLRECIPES("allrecipes.com");


    private String domain;

    private SupportedWebsites(String domain)
    {
        this.domain=domain;
    }

    public String getDomain(){
        return this.domain;
    }

    public static SupportedWebsites ifContains(String line){
        for(SupportedWebsites enumValue : values()){
            if(line.contains(enumValue.getDomain())){
                return enumValue;
            }
        }
        return null;
    }
}
