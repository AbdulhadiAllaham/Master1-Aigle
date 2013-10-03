class VerticalScrollBarDecorator extends WindowDecorator {
    public VerticalScrollBarDecorator (Window decoratedWindow) {
        super(decoratedWindow);
    }
 
    @Override
    public void draw() {
        decoratedWindow.draw();
        drawVerticalScrollBar();
    }
 
    private void drawVerticalScrollBar() {
        // draw the vertical scrollbar
    }
 
    @Override
    public String getDescription() {
        return decoratedWindow.getDescription() + ", including vertical scrollbars";
    }
}