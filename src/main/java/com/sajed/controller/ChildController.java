package com.sajed.controller;

import com.sajed.constants.IConstants;
import com.sajed.models.Child;
import com.sajed.models.ResponseModel;
import com.sajed.repository.AdultRepository;
import com.sajed.service.ChildService;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/child")
public class ChildController implements IConstants {

    @Autowired
    ChildService childService;


    /**
     * Fetches all entries of child table. <p>
     *
     * @return ResponseModel
     * @author Sajed Jalil
     * @date 11-Dec-2020
     */
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    @ResponseBody
    public <T> ResponseModel findAll() {

        log.log(Level.TRACE, "Call: View - Child");
        try {
            List<Child> adultList = childService.findByIsDeletedFalse();
            return convertToJSON(SUCCESS_STATUS, MESSAGE_SUCCESS, adultList);
        } catch (Exception e) {
            log.log(Level.ERROR, e);
            return convertToJSON(FAILED_STATUS, MESSAGE_ERROR, null);
        }

    }


    /**
     * Creates a new entry of child.<p>
     *
     * @param child
     * @return ResponseModel
     * @author Sajed Jalil
     * @date 11-Dec-2020
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public <T> ResponseModel create(@RequestBody Child child) {

        log.log(Level.TRACE, "Call: Create - Child");
        try {
            this.cleanError(child);
            child.setIsDeleted(false);
            Child created = childService.save(child);

            return convertToJSON(SUCCESS_STATUS, MESSAGE_SUCCESS, created);
        } catch (Exception e) {
            log.log(Level.ERROR, e);
            return convertToJSON(FAILED_STATUS, MESSAGE_ERROR, null);
        }

    }

    /**
     * Updates an entry of child<p>
     *
     * @param child
     * @return ResponseModel
     * @author Sajed Jalil
     * @date 11-Dec-2020
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public <T> ResponseModel update(@RequestBody Child child) {

        log.log(Level.TRACE, "Call: Update - Child");
        try {
            this.cleanError(child);
            childService.save(child);
            return convertToJSON(SUCCESS_STATUS, MESSAGE_SUCCESS, child);
        } catch (Exception e) {
            log.log(Level.ERROR, e);
            return convertToJSON(FAILED_STATUS, MESSAGE_ERROR, null);
        }
    }


    /**
     * Deletes an entry of child. Actual entry is not deleted from database.
     * isDeleted field of the object are set to true. This is done due to database log purpose <p>
     *
     * @param child
     * @return ResponseModel
     * @author Sajed Jalil
     * @date 11-Dec-2020
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public <T> ResponseModel delete(@RequestBody Child child) {

        log.log(Level.TRACE, "Call: Delete - Child");
        try {
            this.cleanError(child);
            child.setIsDeleted(true);
            childService.save(child);

            return convertToJSON(SUCCESS_STATUS, MESSAGE_SUCCESS, child);
        } catch (Exception e) {
            log.log(Level.ERROR, e);
            return convertToJSON(FAILED_STATUS, MESSAGE_ERROR, null);
        }
    }

    public void cleanError(Object data) {

        Child child = (Child) data;

        if (child.getChildId() != null && child.getChildId() == 0)
            child.setChildId(null); // If mistakenly 0 is provided as Child ID
        if (child.getAdult().getAdultId() != null && child.getAdult().getAdultId() == 0)
            child.getAdult().setAdultId(null); // If mistakenly 0 is provided as parent ID
    }
}
