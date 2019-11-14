package com.zamoga.portafolioweb.controller;


import com.zamoga.portafolioweb.service.ZemogaProfileService;
import com.zamoga.portafolioweb.vo.ZemogaProfileVO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("zemoga_portfolio_api")
public class ZemogaPortfolioControlller {


    private ZemogaProfileService zemogaProfileService;

    public ZemogaPortfolioControlller(ZemogaProfileService zemogaProfileService) {
        this.zemogaProfileService = zemogaProfileService;
    }

    @ApiOperation(
            value = "Updates the given user data",
            response = ZemogaProfileVO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Updates the given user data JSON"),})
    @ResponseBody
    @RequestMapping(value = "/modify_user_info", method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_VALUE})
    ZemogaProfileVO addPersona(@ApiParam(value = "ID of person to return", required = true) @RequestBody ZemogaProfileVO zemogaProfileVO) {
        return zemogaProfileService.save(zemogaProfileVO);
    }

    @ApiOperation(
            value = "Returns user profile of the name (title) field on the database",
            response = ZemogaProfileVO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Returns user profile of the name (title) field on the database"),})
    @RequestMapping(value = "/user_info/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> findByName(@ApiParam(value = "Name of person to return", required = true) @PathVariable("id") String name) {
        ZemogaProfileVO per = null;
        if (!StringUtils.isEmpty(name)) {
            per = zemogaProfileService.findByName(name);
            if (per != null) {
                return new ResponseEntity<>(per, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("No se encontro id", HttpStatus.NOT_FOUND);
            }
        }
        return new ResponseEntity<>(new ZemogaProfileVO(), HttpStatus.BAD_REQUEST);
    }

}
