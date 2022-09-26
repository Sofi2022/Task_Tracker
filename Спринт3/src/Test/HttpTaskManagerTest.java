package Test;

import Exceptions.ManagerLoadException;
import Http.HttpTaskManager;
import Http.KVServer;
import manager.Managers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import tasks.Task;


import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HttpTaskManagerTest extends ManagerTest<HttpTaskManager>{

    private KVServer kvServer;

    @BeforeEach
    @Override
    void init() throws IOException {
        kvServer = Managers.getDefaultKVServer();
        manager = new HttpTaskManager(KVServer.PORT);
        super.init();
    }

    @AfterEach
    void stopServer(){
        kvServer.stop();
    }

    @Disabled
    @Test
     void save() {

    }

    @Test
    void load() throws ManagerLoadException {
        HttpTaskManager newManager = new HttpTaskManager(KVServer.PORT, true);
        manager.getTaskById(task.getId());
        List<Task> tasksList = newManager.getTaskList();
        assertNotNull(tasksList, "пустой список");
        assertEquals(1, tasksList.size(), "количество задач не совпадает");
        assertEquals(task, tasksList.get(0));
    }
}