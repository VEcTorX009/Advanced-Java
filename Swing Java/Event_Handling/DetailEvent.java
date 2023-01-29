package Event_Handling;

import java.util.EventObject;
public class DetailEvent extends EventObject{

    private String text;
public DetailEvent(Object source, String text) {
    super(source); 
}
public String getText()
{
    return text;
}
}
