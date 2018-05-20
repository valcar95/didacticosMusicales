package didacticosmusicales.Personal.UI.Utilidades.checkList;

public class CheckListItem {

    private String label;
    private boolean isSelected = false;
    private Object data;

    public CheckListItem(String label,Object data) {
        this.setLabel(label);
        this.setData(data);
    }

    public CheckListItem(String label,Object data, boolean isSelected) {
        this.setLabel(label);
        this.data=data;
        this.isSelected=isSelected;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    @Override
    public String toString() {
        return getLabel();
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
