package service.video;

import Pojo.Video;

import java.util.List;

public interface VideoService {
    public boolean add(Video video);
    public List<Integer> getVideoIdList();
    public List<String> getVideoTitleList();
    public List<String> getVideoCoverList();
    public List<String> getVideoSrcList();
}
