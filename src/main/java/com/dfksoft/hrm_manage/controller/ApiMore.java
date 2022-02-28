package com.dfksoft.hrm_manage.controller;

import com.dfksoft.hrm_manage.entity.AccountInfo;
import com.dfksoft.hrm_manage.entity.Device;
import com.dfksoft.hrm_manage.model.UserApiData;
import com.dfksoft.hrm_manage.service.AccountInfoService;
import com.dfksoft.hrm_manage.service.AccountService;
import com.dfksoft.hrm_manage.service.DeviceService;
import com.dfksoft.hrm_manage.service.SystemDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
public class ApiMore {
    @Autowired
    private final DeviceService deviceService;
    private final SystemDeviceService systemDeviceService;
    private final AccountService accountService;
    private final AccountInfoService accountInfoService;

    public ApiMore(DeviceService deviceService, SystemDeviceService systemDeviceService, AccountService accountService, AccountInfoService accountInfoService) {
        this.deviceService = deviceService;
        this.systemDeviceService = systemDeviceService;
        this.accountService = accountService;
        this.accountInfoService = accountInfoService;
    }

    @PostMapping(value = "/api/user/detail")
    public ResponseEntity<?> getUserInformation(@RequestBody String mac_address){
        Device device = new Device();
        AccountInfo accountInfo = new AccountInfo();
        UserApiData userApiData = new UserApiData();
        if(Objects.nonNull(device)){
            System.out.println("AAAAAAAA");
            System.out.println(mac_address + "  Hello");
            //device = deviceService.findDeviceByMacAddress("02:00:00:44:55:66");
            mac_address = splitString(mac_address);
            mac_address = replaceFormat(mac_address);
            device = deviceService.findDeviceByMacAddress(mac_address);
            accountInfo = accountInfoService.getAccountInfoByAccountId(device.getAccountId());
            userApiData.setStatus(200);
            userApiData.setAccountInfo(accountInfo);

//            Map<String, Object> map = new HashMap<>();
//            map.put("status", 200);
//            accountInfo.setAccount(null);
//            map.put("data_report", accountInfo);

            return ResponseEntity.ok(userApiData);
            //return new ResponseEntity<Object>(map, HttpStatus.OK);
        }
        else {
            deviceService.addNewDevice("Device tesst 1", mac_address, 1);
        }
        return ResponseEntity.ok(userApiData);
    }

    private String replaceFormat(String mac){
       try {
            String result = java.net.URLDecoder.decode(mac, StandardCharsets.UTF_8.name());
            return result;
       }catch (Exception e){

       }
       return "";
    }

    private String splitString(String text){
        String[] n = text.split("=", -1);
        System.out.println(n);
        return n[1].toString();
    }


//    @PostMapping(value = "/api/user/detail")
//    public ResponseEntity<?> getUserInformation(@RequestBody String mac_address){
//        SystemDevice device = new SystemDevice();
//        device = systemDeviceService.getAllSystemDevice().get(0);
//        //findDeviceByMacAddress("02:00:00:00:01:00");
//        if(Objects.nonNull(device)){
//            System.out.println(device.getMacAddress());
//            return ResponseEntity.ok(device);
//        }
//        else {
//            System.out.println("AAAAAAAA2315");
//            deviceService.addNewDevice("Device tesst", mac_address, 1);
//        }
//        System.out.println("AAAAAAAA");
////        List<Device> listDevice = deviceService.getAllDevice();
////        device = listDevice.get(0);
//
//        return ResponseEntity.ok(device);
//    }
}
