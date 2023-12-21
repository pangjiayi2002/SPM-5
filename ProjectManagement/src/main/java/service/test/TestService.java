package service.test;

import Pojo.Test;

import java.util.List;

public interface TestService {
    public boolean add(Test notice);

    List<Test> getAll() throws Exception;

    public Test getById(String id);

    public boolean modify(Test notice);

    public boolean deleteById(String id);

}
