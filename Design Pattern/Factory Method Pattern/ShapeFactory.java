public class ShapeFactory {
    private ShapeFactory(){
    }
    public static Shape getShape(ShapeType shapeType){
		if (shapeType == null)
            return null;
        switch (shapeType){
            case CIRCLE:
                return new Circle();
            case SQUARE:
                return new Square();
            case RECTANGLE:
                return new Rectangle();
            default:
                throw new IllegalArgumentException("Not supported this shape");
        }
    }
}
