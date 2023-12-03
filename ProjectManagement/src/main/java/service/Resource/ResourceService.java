package service.Resource;

import Pojo.Resource;

import java.util.ArrayList;

public interface ResourceService {
    //根据type返回所有这种type的学习资料
    public ArrayList<Resource> getResourceListByType(String type);

    //添加学习资料
    boolean add(Resource resource);
}
