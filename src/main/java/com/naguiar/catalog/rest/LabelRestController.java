/**
 * 
 */
package com.naguiar.catalog.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.naguiar.catalog.model.Label;
import com.naguiar.catalog.service.LabelService;

/**
 * @author naty
 *
 */
@RestController
@RequestMapping("/rest/label")
public class LabelRestController {

	@Autowired
	private LabelService labelService;

	/**
	 * List Labels
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public List<Label> listLabels() {
		return this.labelService.list();
	}
	
	/**
	 * Save
	 * @param label
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, headers = {"Content-type=application/json"})
	@ResponseBody
	public Label saveLabel( @RequestBody Label label ) {
		return labelService.createOrUpdate(label);
	}
}