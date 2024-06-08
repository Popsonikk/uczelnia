import java.util.HashMap;
import java.util.Map;

public class CommandService {
    private Map<String,Book> library;
    CommandService()
    {
        this.library=new HashMap<>();
    }

    public Map<String, Book> getLibrary() {
        return library;
    }

    public void handle(SetCommand command) throws Exception {
        if(!library.containsKey(command.getName()))
        {
            library.put(command.getName(), new Book(command.getName(), true));
        }
        else {
            throw new Exception("Book already exist");
        }
    }
    public void handle(GetCommand command) throws Exception {
        if(library.containsKey(command.getName()))
        {
            if(library.get(command.getName()).isAvailable())
                library.get(command.getName()).setAvailable(false);
            else
                throw new Exception("Book already taken");
        }
        else
            throw new Exception("Book doesn't exist");
    }
    public void handle(ReturnCommand command) throws Exception {
        if(library.containsKey(command.getName()))
        {
            library.get(command.getName()).setAvailable(true);
        }
        else
            throw new Exception("Book doesn't exist");
    }


}
