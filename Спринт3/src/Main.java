import Exceptions.ManagerLoadException;
import Http.KVServer;
import manager.Managers;
import manager.TaskManager;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ManagerLoadException {

        KVServer kvserver = Managers.getDefaultKVServer();
        TaskManager manager = Managers.getDefault();


    }
}
