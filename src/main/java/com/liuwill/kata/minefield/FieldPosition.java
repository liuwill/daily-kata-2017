package com.liuwill.kata.minefield;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiuWill on 2017/5/14.
 */
public class FieldPosition {
    private String id;
    private Integer x;
    private Integer y;

    public FieldPosition(int x, int y) {
        this.x = x;
        this.y = y;

        id = x + ":" + y;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public List<FieldPosition> getNeighbours(FieldDimension fieldDimension) {
        ArrayList<FieldPosition> neighbours = new ArrayList();

        int[][] calculators = {{-1, -1}, {0, -1}, {1, -1}, {-1, 0}, {1, 0}, {-1, 1}, {0, 1}, {1, 1}};
        for (int[] calculator : calculators) {
            int posX = x + calculator[0];
            int posY = y + calculator[1];

            if (posX < 0 || posX >= fieldDimension.getWidth()) {
                continue;
            } else if (posY < 0 || posY >= fieldDimension.getHeight()) {
                continue;
            }

            neighbours.add(new FieldPosition(posX, posY));
        }
        return neighbours;
    }

    public String toString() {
        return "Position [x:" + x + " - y:" + y + "]";
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof FieldPosition)) {
            return false;
        }
        FieldPosition fieldPosition = (FieldPosition) o;

        return fieldPosition.id.equals(this.id);
    }

    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
