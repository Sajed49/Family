package com.sajed.controller;

import com.sajed.constants.IConstants;
import com.sajed.models.Adult;
import com.sajed.models.ResponseModel;
import com.sajed.repository.AddressRepository;
import com.sajed.repository.AdultRepository;
import com.sajed.service.AddressService;
import com.sajed.service.AdultService;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/adult")
public class AdultController implements IConstants {


    @Autowired
    AdultService adultService;

    @Autowired
    AddressService addressService;

    /**
     * Fetches all entries of adult table. <p>
     *
     * @return ResponseModel
     * @author Sajed Jalil
     * @date 11-Dec-2020
     */
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    @ResponseBody
    public <T> ResponseModel findAll() {

        log.log(Level.TRACE, "Call: View - Adult");
        try {
            List<Adult> adultList = adultService.findByIsDeletedFalse();
            return convertToJSON(SUCCESS_STATUS, MESSAGE_SUCCESS, adultList);
        } catch (Exception e) {
            log.log(Level.ERROR, e);
            return convertToJSON(FAILED_STATUS, MESSAGE_ERROR, null);
        }

    }

    /**
     * Creates a new entry of adult and address.<p>
     *
     * @param adult
     * @return ResponseModel
     * @author Sajed Jalil
     * @date 11-Dec-2020
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public <T> ResponseModel create(@RequestBody Adult adult) {

        log.log(Level.TRACE, "Call: Create - Adult");
        try {
            adult.setIsDeleted(false);
            adult.getAddress().setIsDeleted(false);
            adultService.save(adult);

            return convertToJSON(SUCCESS_STATUS, MESSAGE_SUCCESS, adult);
        } catch (Exception e) {
            log.log(Level.ERROR, e);
            return convertToJSON(FAILED_STATUS, MESSAGE_ERROR, null);
        }

    }

    /**
     * Updates an entry of adult and corresponding addresses.<p>
     *
     * @param adult
     * @return ResponseModel
     * @author Sajed Jalil
     * @date 11-Dec-2020
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public <T> ResponseModel update(@RequestBody Adult adult) {

        log.log(Level.TRACE, "Call: Update - Adult");
        try {
            adultService.save(adult);
            return convertToJSON(SUCCESS_STATUS, MESSAGE_SUCCESS, adult);
        } catch (Exception e) {
            log.log(Level.ERROR, e);
            return convertToJSON(FAILED_STATUS, MESSAGE_ERROR, null);
        }
    }


    /**
     * Deletes an entry of adult and corresponding addresses. Actual entry is not deleted from database.
     * isDeleted field of the objects are set to true. This is done due to database log purpose <p>
     *
     * @param adult
     * @return ResponseModel
     * @author Sajed Jalil
     * @date 11-Dec-2020
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public <T> ResponseModel delete(@RequestBody Adult adult) {

        log.log(Level.TRACE, "Call: Delete - Adult");
        try {

            adult.setIsDeleted(true);
            adult.getAddress().setIsDeleted(true);
            adultService.save(adult);

            return convertToJSON(SUCCESS_STATUS, MESSAGE_SUCCESS, adult);
        } catch (Exception e) {
            log.log(Level.ERROR, e);
            return convertToJSON(FAILED_STATUS, MESSAGE_ERROR, null);
        }
    }

    @Override
    public void cleanError(Object data) {
        Adult adult = (Adult) data;
        if (adult.getAdultId() != null && adult.getAdultId() == 0)
            adult.setAdultId(null); // If mistakenly 0 is provided as Child ID
        if (adult.getAddress().getAddressId() != null && adult.getAddress().getAddressId() == 0)
            adult.getAddress().setAddressId(null); // If mistakenly 0 is provided as parent ID
    }
}
