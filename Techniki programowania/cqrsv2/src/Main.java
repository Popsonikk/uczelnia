public class Main {
    public static void main(String[] args) throws Exception {
        CommandService commandService=new CommandService();
        QueryService queryService=new QueryService(commandService.getLibrary());

        commandService.handle(new SetCommand("book"));
        commandService.handle(new SetCommand("book2"));
        commandService.handle(new GetCommand("book"));
        commandService.handle(new GetCommand("book2"));
        commandService.handle(new ReturnCommand("book"));

        System.out.println(queryService.handle(new IsExistQuery("book3")));
        System.out.println(queryService.handle(new IsAvaiableQuery("book")));



    }
}