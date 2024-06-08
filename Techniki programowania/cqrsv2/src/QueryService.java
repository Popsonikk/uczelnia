import java.util.HashMap;
import java.util.Map;

public class QueryService {
    private Map<String,Book> library;
    QueryService(Map<String,Book> map)
    {
        this.library=map;
    }

    public boolean handle(IsAvaiableQuery query)
    {
        if(library.containsKey(query.getName()))
        {
           return library.get(query.getName()).isAvailable();
        }
        return false;

    }
    public boolean handle (IsExistQuery query)
    {
        if(library.containsKey(query.getName()))
            return true;
        else
            return false;
    }


}
