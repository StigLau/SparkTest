
import static spark.Spark.*;
import spark.*;
import com.google.gson.Gson;

public class HelloWorld {
    public static void main(String[] args) {
        get("/hello", (request, response) -> {
            return "Hello World";
        });

        get("/helloAsJson", "application/json", (request, response)
                -> new MyMessage("Hello World"), new JsonTransformer());
    }
}

class MyMessage {
    String name;
    public MyMessage(String name) {
        this.name = name;
    }
}

class JsonTransformer implements ResponseTransformer {
    public String render(Object model) {
        return new Gson().toJson(model);
    }
}