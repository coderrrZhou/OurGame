package ssm.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.dao.PageDao;
import ssm.service.PageService;

@Service("pageService")
public class PageServiceImpl implements PageService {

    @Autowired(required = false)
    private PageDao pageDao;


    @Override
    public int getPages() {
        return pageDao.getPages();
    }
}
