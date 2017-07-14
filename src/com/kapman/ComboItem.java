package com.kapman;

/**
 * https://stackoverflow.com/questions/17887927/adding-items-to-a-jcombobox
 */
public class ComboItem {
    private int key;
    private String value;

    public ComboItem(int key, String value)
    {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString()
    {
        return value;
    }

    public Integer getKey()
    {
        return key;
    }

    public String getValue()
    {
        return value;
    }
}
