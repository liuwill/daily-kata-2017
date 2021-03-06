package com.liuwill.kata.minefield;

/**
 * Created by LiuWill on 2017/5/14.
 */
public class FieldDimension {
    private int width;
    private int height;
    private String id;

    public FieldDimension(int width, int height) {
        this.width = width;
        this.height = height;

        id = width + ":" + height;
    }

    public int size() {
        return width * height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean equals(FieldDimension dimension) {
        if (dimension == null) {
            return false;
        } else if (this.getHeight() != dimension.getHeight()) {
            return false;
        } else if (this.getWidth() != dimension.getWidth()) {
            return false;
        }

        return true;
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof FieldDimension)) {
            return false;
        }
        FieldDimension fieldDimension = (FieldDimension) o;

        return fieldDimension.id.equals(this.id);
    }

    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Dimension [width:" + width + " - height:" + height + "]";
    }
}
