package com.tide.web.controller.cultural;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tide.common.annotation.Log;
import com.tide.common.core.controller.BaseController;
import com.tide.common.core.domain.AjaxResult;
import com.tide.common.enums.BusinessType;
import com.tide.cultural.domain.CulturalTopic;
import com.tide.cultural.service.ICulturalTopicService;
import com.tide.common.utils.poi.ExcelUtil;
import com.tide.common.core.page.TableDataInfo;

/**
 * 文化专题Controller
 * 
 * @author haipeng-lin
 * @date 2024-11-20
 */
@RestController
@RequestMapping("/cultural/culturalTopic")
public class CulturalTopicController extends BaseController
{
    @Autowired
    private ICulturalTopicService culturalTopicService;

    /**
     * 查询文化专题列表
     */
    @PreAuthorize("@ss.hasPermi('cultural:culturalTopic:list')")
    @GetMapping("/list")
    public TableDataInfo list(CulturalTopic culturalTopic)
    {
        startPage();
        List<CulturalTopic> list = culturalTopicService.selectCulturalTopicList(culturalTopic);
        return getDataTable(list);
    }

    /**
     * 导出文化专题列表
     */
    @PreAuthorize("@ss.hasPermi('cultural:culturalTopic:export')")
    @Log(title = "文化专题", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CulturalTopic culturalTopic)
    {
        List<CulturalTopic> list = culturalTopicService.selectCulturalTopicList(culturalTopic);
        ExcelUtil<CulturalTopic> util = new ExcelUtil<CulturalTopic>(CulturalTopic.class);
        util.exportExcel(response, list, "文化专题数据");
    }

    /**
     * 获取文化专题详细信息
     */
    @PreAuthorize("@ss.hasPermi('cultural:culturalTopic:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(culturalTopicService.selectCulturalTopicById(id));
    }

    /**
     * 新增文化专题
     */
    @PreAuthorize("@ss.hasPermi('cultural:culturalTopic:add')")
    @Log(title = "文化专题", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CulturalTopic culturalTopic)
    {
        culturalTopic.setCreateBy(getUsername());
        return toAjax(culturalTopicService.insertCulturalTopic(culturalTopic));
    }

    /**
     * 修改文化专题
     */
    @PreAuthorize("@ss.hasPermi('cultural:culturalTopic:edit')")
    @Log(title = "文化专题", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CulturalTopic culturalTopic)
    {
        culturalTopic.setUpdateBy(getUsername());
        return toAjax(culturalTopicService.updateCulturalTopic(culturalTopic));
    }

    /**
     * 删除文化专题
     */
    @PreAuthorize("@ss.hasPermi('cultural:culturalTopic:remove')")
    @Log(title = "文化专题", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(culturalTopicService.deleteCulturalTopicByIds(ids));
    }
}
