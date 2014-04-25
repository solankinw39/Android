package com.nitgen.SDK.AndroidBSP;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.UUID;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.webkit.WebView;
import android.widget.Toast;
import java.util.Arrays;

public class Tas_Plugin 
{
	static Context context;
	static Android_Demo AndroidTASActivity;
	
    // Key names received from the BluetoothChatService Handler
    public static final String DEVICE_NAME = "device_name";
    public static final String TOAST = "toast";
    
    private static StringBuffer mOutStringBuffer;
    static Thread m_hReadThread;
    
    public enum commandType
    {
    	AUTO_SCAN,REGISTER_USER,MODIFY_USER,DELETE_USER,CHECK_DEVICE,ENTER_MASTER_MODE_FP,ENTER_MASTER_MODE_PW,LEAVE_MASTER_MODE,
    }
    
		
	public Tas_Plugin(Android_Demo androidtas, WebView appView) {
		context = androidtas.getApplicationContext();
		AndroidTASActivity = androidtas;
	}
	
	public int selectDevice()
	{
		int returnval;
		Toast.makeText(context, "Connecting to Scanner...", Toast.LENGTH_SHORT).show();
		returnval = AndroidTASActivity.OnBtnOpenDevice();
		return returnval;
	}
	
	public int ValidateAdmin(String username,String password)
	{
		int returnval;
		returnval = AndroidTASActivity.ValidateAdminUser(username,password);
		return returnval;
	}
	
		
	public boolean connectDevice()
	{	
		Toast.makeText(context, "sendMessage...", Toast.LENGTH_SHORT).show();
		return true;
	}
	
	public  int disconnectDevice()
	{
		int returnval;
		Toast.makeText(context, "Closing...", Toast.LENGTH_SHORT).show();
		returnval = AndroidTASActivity.OnBtnCloseDevice();
		return returnval;
	}
	public  int ExitApplication()
	{
		int returnval;
		Toast.makeText(context, "Closing Application...", Toast.LENGTH_SHORT).show();
		returnval = AndroidTASActivity.exitApplication();
		return returnval;
	}
	public int givelastid()
	{
		return AndroidTASActivity.getLastId();
	}
	
	static Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
		Bundle b = msg.getData();
		String key = b.getString("My Key");
		Toast.makeText(context, "From Device - " + key, Toast.LENGTH_SHORT).show();
		//display each item in a single line
		 
		}
	 };
	
	public void sendCommand(String command )
	{
		Toast.makeText(context, "sendMessage...", Toast.LENGTH_LONG).show();
		Toast.makeText(context, "sendMessage...Completed", Toast.LENGTH_LONG).show();
	}
	
	public int deleteUserId(int d_uid)
	{
		AndroidTASActivity.Delete(d_uid);
		return 1;
	}
	
	public int mastercheck()
	{
		return AndroidTASActivity.masterPresencecheck();
	}
	
	public int enter_master_mode_FP(int userID)
	{
		return userID;
	}
	
	
	public int enter_master_mode_PW(int userID,int userPW)
	{
		return AndroidTASActivity.masterPW(userID, userPW);
	}
	

	public int register_new_FP(int userID,int userPW,String fname,String lname,String dob,int phoneno ,String country,String nationality ,String city ,String sex)
	{
		return AndroidTASActivity.Insert(Integer.toString(userID),Integer.toString(userPW),fname,lname,dob,Integer.toString(phoneno) , country, nationality , city , sex);
		//return 1;
	}
	
	public String EditUserInformation(int userID)
	{
			return AndroidTASActivity.EditUserInformationCollect(userID);
    }
	
	public String EditAdminUserInformation(int userID)
	{
		return AndroidTASActivity.EditAdminUserInformationCollect(userID);
    }
	

	public String Verify_FP(int userID)
	{
			return AndroidTASActivity.OnBtnVerify(userID);
    }
	
	public String Identify_FP()
	{
		return AndroidTASActivity.OnBtnIdentify();
	}	
	
	
public String Capture_New_Fp(int fpId)
{
	String imgdata=AndroidTASActivity.OnBtnCapture1(fpId);
    return imgdata; 
}
public void WriteLogFile(String log) 
{
	AndroidTASActivity.WriteLogCSV(log);
}

public void StatusBarStatus(int satatus) throws IOException
{
	if(satatus == 0)
	{
		AndroidTASActivity.KillStatusBar();
	}
	else
	{
		AndroidTASActivity.StartStatusBar();
	}
}

public void setSystemReadWrite()throws IOException
{
	//AndroidTASActivity.SetSystemRW();
	AndroidTASActivity.ShowSettingScreen();
}

public void setFpDeviceSettings(String eqs,String iqs,String vqs,String sls,String dtos,String bris,String contrs,String gainset,String postt)
{
	//AndroidTASActivity.SetInfo1();
	AndroidTASActivity.SetInfo2();
	//AndroidTASActivity.UpdateDeviceSetting( eqs, iqs, vqs, sls, dtos, bris, contrs, gainset, postt);
}

public String giveDeviceSetFrmDB()
{
	return AndroidTASActivity.DeviceSetFrmDB();
}


public void postdatarequest()
{
	AndroidTASActivity.postData();
}

public String giveIMEI()
{
	return AndroidTASActivity.getIMEI();
}

public int callNetworkSetting(int calltype)
{
	return AndroidTASActivity.NetworkSetting(calltype);
}

public String giveMacID()//info
{
	return AndroidTASActivity.getMacID();
}
public float giveBatteryLevel()//info
{
	return AndroidTASActivity.getBatteryLevel();
}
public String giveConnectingToInternet()//info
{
	return AndroidTASActivity.getConnectingToInternet();
}

public int giveUsercount()
{
	return AndroidTASActivity.userCount();
}
public int giveMasterUsercount()
{
	return AndroidTASActivity.MasteruserCount();
}

public void openCamera()
{
	AndroidTASActivity.callCamera();
	
}

public String photoStr()
{
	return AndroidTASActivity.Photostrdata();
}

public void AutoscanMode()
{
	AndroidTASActivity.StartAutoscan();
}

public void OffAutoscanMode()
{
	AndroidTASActivity.StopAutoscan();
}
public String AutoScanResult()
{
	return AndroidTASActivity.AUResult();
}

public void SetStrNO_DATA()
{
	AndroidTASActivity.SetStrNODATA();
}

public void nidentify()
{
	AndroidTASActivity.OnIdentify(5000);
}

public void addFPsTonSearch()
{
	AndroidTASActivity.addFptoIndexSearch();
}
public String usermangement()
{
	return AndroidTASActivity.UserMangement();
}
public String EditUserCall(String uid,String fname,String lname,String dob,String phoneno,String country,String nationality,String city,String sex)
{
	return AndroidTASActivity.UpdateUser( uid, fname, lname, dob, phoneno, country, nationality, city, sex);
}


public String UpdateAdminUserCall(String auid,String afname,String alname,String auname,String apass,String apnumber)
{
	return AndroidTASActivity.UpdateAdminUser(auid,auname,apass,afname,alname,apnumber);
}

public String countMinotia()
{
	return AndroidTASActivity.countMinotia();
}

}


