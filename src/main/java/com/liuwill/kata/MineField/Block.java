package com.liuwill.kata.MineField;

/**
 * Created by videopls on 2017/5/15.
 */
public class Block implements FieldEcho,Printable {
    private BaseEntity blockItem;
    protected Integer nearCount;

    public Block(BaseEntity baseEntity){
        blockItem = baseEntity;
        nearCount = 0;
    }

    @Override
    public String getIcon() {
        if(blockItem.isMine()){
            return blockItem.getIcon();
        }
        return nearCount.toString();
    }

    @Override
    public String getRawIcon() {
        return blockItem.getRawIcon();
    }

    @Override
    public boolean isMine() {
        return blockItem.isMine();
    }

    @Override
    public int getCount() {
        return nearCount;
    }

    public FieldPosition getFieldPosition(){
        return blockItem.getFieldPosition();
    }

    public void setBlockItem(BaseEntity blockItem) {
        this.blockItem = blockItem;
    }

    public void updateCount() {
        this.nearCount++;
    }
}
