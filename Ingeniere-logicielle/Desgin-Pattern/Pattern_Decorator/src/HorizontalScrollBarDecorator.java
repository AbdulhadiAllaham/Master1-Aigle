class HorizontalScrollBarDecorator extends WindowDecorator {
    public HorizontalScrollBarDecorator (Window decoratedWindow) {
        super(decoratedWindow);
    }
 
    @Override
    public void draw() {
        decoratedWindow.draw();
        drawHorizontalScrollBar();
    }
 
    private void drawHorizontalScrollBar() {
        // draw the horizontal scrollbar
    }
 
    @Override
    public String getDescription() {
        return decoratedWindow.getDescription() + ", including horizontal scrollbars";
    }
}