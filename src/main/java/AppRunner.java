import com.cs.canvas.components.Canvas;
import com.cs.canvas.handler.*;

import java.util.*;

public class AppRunner {
    private static Scanner        scanner;
    private static Map<String,Handler> handlerMap;
    private static Canvas cs;

    public static void main(String args[]){
        scanner = new Scanner(System.in);
        System.out.println("Enter command:");
        while (scanner.hasNext()) {
            handleRequest(scanner.nextLine());
            System.out.println("Enter command:");
        }
    }

    private static void handleRequest(String request){
        String [] req = request.split(" ");
        Handler handler;
        if(req.length > 0){
            handler = handlerMap.getOrDefault(req[0],handlerMap.get("invalid"));
        }else{
            handler = handlerMap.get("invalid");
        }
        try{
        Optional<Canvas> opt = handler.handleRequest(cs,request);
        if(opt.isPresent()){
            cs = opt.get();
            cs.paint();
        }
        }catch (IllegalArgumentException e){
            System.out.print(e.getLocalizedMessage() + ". ");
            handlerMap.get("invalid").handleRequest(cs,request);
        }
    }

    static {
        handlerMap = new HashMap<>();
        Handler canvasHandler = new CanvasHandler();
        Handler lineHandler = new LineHandler();
        Handler rectangleHandler = new RectangleHandler();
        Handler bucketFillHandler = new BucketFillHandler();
        Handler terminationHandler = new TerminationHandler();
        Handler invalidRequestHandler = new InvalidRequestHandler();

        handlerMap.put(canvasHandler.getSymbol(),canvasHandler);
        handlerMap.put(lineHandler.getSymbol(),lineHandler);
        handlerMap.put(rectangleHandler.getSymbol(),rectangleHandler);
        handlerMap.put(bucketFillHandler.getSymbol(),bucketFillHandler);
        handlerMap.put(terminationHandler.getSymbol(),terminationHandler);
        handlerMap.put(invalidRequestHandler.getSymbol(),invalidRequestHandler);
    }
}
