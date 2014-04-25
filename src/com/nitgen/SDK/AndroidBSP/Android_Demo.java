package com.nitgen.SDK.AndroidBSP;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.ByteBuffer;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import android.media.audiofx.BassBoost.Settings;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.PowerManager;
import android.provider.MediaStore;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.TabActivity;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.telephony.TelephonyManager;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;


import com.nitgen.SDK.AndroidBSP.NBioBSPJNI.IndexSearch.FP_INFO;
import com.nitgen.SDK.AndroidBSP.NBioBSPJNI.IndexSearch.SAMPLE_INFO;
import com.nitgen.SDK.AndroidBSP.NBioBSPJNI.*;

import org.apache.cordova.DroidGap;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
public class Android_Demo extends DroidGap  implements NBioBSPJNI.CAPTURE_CALLBACK  {
	//hello bioenable
	
	
	private SQLiteDatabase db,db1,db2,db3;
    private String table_name="emploeeinfo";
    private String table_name1="logdata";
    private String table_name2="deviceset";
    private String table_name3="adminuser";
    private String database_name="Test";
   
    
   int flag=0;
    
   public byte[] fingerprint=null;
   public byte[] fingerprint2=null;
   public byte[] fingerprint3=null;
   public byte[] fingerprint4=null;
   public byte[] fingerprint5=null;
   public byte[] fingerprint6=null;
   public byte[] fingerprint7=null;
   public byte[] fingerprint8=null;
   public byte[] fingerprint9=null;
   public byte[] fingerprint10=null;
   
   public byte[] userImage,fpimg1,fpimg2,fpimg3,fpimg4,fpimg5,fpimg6,fpimg7,fpimg8,fpimg9,fpimg10;
   
   //Added By nilesh
   public static final String KEY_ADMINID = "adminId";
   
   public static final String KEY_ADMINUSER = "adminUser";
   
   public static final String KEY_ADMINPWD = "adminPasswd";
   
   public static final String KEY_ADMINFNAME = "adminFname";
   
   public static final String KEY_ADMINLNAME = "adminLname";
   
   public static final String KEY_ADMINCONTACT = "adminContact";
   
   public static final String KEY_ADMINEMAIL = "adminEmail";
   
   //End admin table 
 
   public static final String KEY_ROWID = "sid";
    
    public static final String KEY_UID = "uid";
    
    public static final String KEY_PASSWD = "passwd";

    public static final String KEY_FNAME = "fname";

    public static final String KEY_LNAME = "lname";
    
    public static final String KEY_DOB = "dob";
    
    //public static final String KEY_DPART = "did";
    public static final String KEY_PHONENO = "phoneno"; 
    
    public static final String KEY_COUNTRY = "country";
    
    public static final String KEY_NATIONALITY = "nationality";
    
    public static final String KEY_CITY = "city";
    
    public static final String KEY_SEX = "sex";
    
    public static final String KEY_FPDATA = "fpdata";
    public static final String KEY_FPDATA2 = "fpdata2";
    public static final String KEY_FPDATA3 = "fpdata3";
    public static final String KEY_FPDATA4 = "fpdata4";
    public static final String KEY_FPDATA5 = "fpdata5";
    public static final String KEY_FPDATA6 = "fpdata6";
    public static final String KEY_FPDATA7 = "fpdata7";
    public static final String KEY_FPDATA8 = "fpdata8";
    public static final String KEY_FPDATA9 = "fpdata9";
    public static final String KEY_FPDATA10 = "fpdata10";

    public static final String KEY_IMGDATA = "imgdata";
    
   
    public static final String KEY_PCID = "pcid";
    
    public static final String KEY_PUID = "puid";

    public static final String KEY_PDATE = "pdate";

    public static final String KEY_PTIME = "ptime";
    
    
    public static final String KEY_SETID = "setid";
    
    public static final String KEY_EQS = "eqs";
    
    public static final String KEY_IQS = "iqs";
    
    public static final String KEY_VQS = "vqs";

    public static final String KEY_SLS = "sls";

    public static final String KEY_DTOS = "dtos";
    
    public static final String KEY_BRIS = "bris";

    public static final String KEY_CONTRS = "contrs";

    public static final String KEY_GAINSET = "gainset";
    
    public static final String KEY_POSTT = "postt";
    
    
   public static int fpmatchsuccess=0;
    
 // create or open database file

   // String setid,String eqs,String iqs,String vqs,String sls,String dtos,String bris,String contrs,String gains
     

// capture button id and perform function/

                // Insert("1111","sagar","gunjal","18-05-1989","1", "BBA");


    public int InsertDeviceSetting(String eqs,String iqs,String vqs,String sls,String dtos,String bris,String contrs,String gainset,String postt)
    {
       ContentValues data=createContentValuesSettingData(eqs,iqs,vqs,sls,dtos,bris,contrs,gainset,postt);
       db2.insert(table_name2, null, data);

       Toast.makeText(this, "Setting saved Successfully", Toast.LENGTH_SHORT).show();
       return 1;
    }
    
// inserting record in the database
   
    public int InsertAdminData(String adminId,String adminUser,String adminPasswd,String adminFname,String adminLname,String adminContact,String adminEmail)
    {
       ContentValues data=createContentValuesAdminData(adminId,adminUser,adminPasswd,adminFname,adminLname,adminContact,adminEmail);
       db3.insert(table_name3, null, data);

       //Toast.makeText(this, "Admin information Inserted Successfully", Toast.LENGTH_SHORT).show();
       return 1;
    }
    
    
    public String UpdateAdminUser(String adminId,String adminUser,String adminPasswd,String adminFname,String adminLname,String adminContact)
    {

       ContentValues updateValues = createContentValuesUpdateAdminUser(adminUser,adminPasswd,adminFname,adminLname,adminContact);
       db3.update(table_name3, updateValues, KEY_ADMINID+"="+adminId+"", null);
       //return adminId+" "+adminUser;
       Toast.makeText(this, "Admin Information Updated Successfully", Toast.LENGTH_SHORT).show();
       return "updateUserOK";
    }
    

    public String UpdateUser(String uid,String fname,String lname,String dob,String phoneno,String country,String nationality,String city,String sex)
    {

    	File mediaStorageDir = new File(Environment.getExternalStorageDirectory()
                + "/EnrollementData/" + uid);
    	if (! mediaStorageDir.exists()){
            if (! mediaStorageDir.mkdirs()){
               // return null;
            }
        }
    	
    	
    	ContentValues values = new ContentValues();
 		
    	values.put(KEY_FNAME, fname);
 	    values.put(KEY_LNAME, lname);
 	    values.put(KEY_DOB, dob);
 	    values.put(KEY_PHONENO ,phoneno);
 	    values.put( KEY_COUNTRY ,country);
 	    values.put( KEY_NATIONALITY,nationality); 
 	    values.put( KEY_CITY ,city);
 	    values.put( KEY_SEX ,sex);
 	    
    	if(fingerprint!=null)
    	{	writeminotia(fingerprint,"/sdcard/EnrollementData/"+ uid + "/"+uid+"_Finger1");
    		ByteArrayInputStream imageStream = new ByteArrayInputStream(fpimg1);
    		Bitmap bitmap = BitmapFactory.decodeStream(imageStream);
    		storeImage(bitmap,uid,"_IMGFinger1");
    		values.put(KEY_FPDATA, fingerprint);
    	}		
    	if(fingerprint2!=null)
    	{	writeminotia(fingerprint2,"/sdcard/EnrollementData/"+ uid + "/"+uid+"_Finger2");
    		ByteArrayInputStream imageStream = new ByteArrayInputStream(fpimg2);
    		Bitmap bitmap = BitmapFactory.decodeStream(imageStream);
    		storeImage(bitmap,uid,"_IMGFinger2");
    		values.put(KEY_FPDATA2, fingerprint2);
    	}		
    	if(fingerprint3!=null)
    		{writeminotia(fingerprint3,"/sdcard/EnrollementData/"+ uid + "/"+uid+"_Finger3");
    	ByteArrayInputStream imageStream = new ByteArrayInputStream(fpimg3);
    	Bitmap bitmap = BitmapFactory.decodeStream(imageStream);
    	storeImage(bitmap,uid,"_IMGFinger3");
    	values.put(KEY_FPDATA3, fingerprint3);
    }		
    	if(fingerprint4!=null)
    		{writeminotia(fingerprint4,"/sdcard/EnrollementData/"+ uid + "/"+uid+"_Finger4");
    		ByteArrayInputStream imageStream = new ByteArrayInputStream(fpimg4);
    		Bitmap bitmap = BitmapFactory.decodeStream(imageStream);
    		storeImage(bitmap,uid,"_IMGFinger4");
    		values.put(KEY_FPDATA4, fingerprint4);
    	}		
    	if(fingerprint5!=null)
    		{writeminotia(fingerprint5,"/sdcard/EnrollementData/"+ uid + "/"+uid+"_Finger5");
    		ByteArrayInputStream imageStream = new ByteArrayInputStream(fpimg5);
    		Bitmap bitmap = BitmapFactory.decodeStream(imageStream);
    		storeImage(bitmap,uid,"_IMGFinger5");
    		values.put(KEY_FPDATA5, fingerprint5);
    	}		
    		
    	if(fingerprint6!=null)
    	{	writeminotia(fingerprint6,"/sdcard/EnrollementData/"+ uid + "/"+uid+"_Finger6");
    	ByteArrayInputStream imageStream = new ByteArrayInputStream(fpimg6);
    	Bitmap bitmap = BitmapFactory.decodeStream(imageStream);
    	storeImage(bitmap,uid,"_IMGFinger6");
    	values.put(KEY_FPDATA6, fingerprint6);
    }		
    	if(fingerprint7!=null)
    	{	writeminotia(fingerprint7,"/sdcard/EnrollementData/"+ uid + "/"+uid+"_Finger7");
    	ByteArrayInputStream imageStream = new ByteArrayInputStream(fpimg7);
    	Bitmap bitmap = BitmapFactory.decodeStream(imageStream);
    	storeImage(bitmap,uid,"_IMGFinger7");
    	values.put(KEY_FPDATA7, fingerprint7);
    }		
    	if(fingerprint8!=null)
    	{	writeminotia(fingerprint8,"/sdcard/EnrollementData/"+ uid + "/"+uid+"_Finger8");
    	ByteArrayInputStream imageStream = new ByteArrayInputStream(fpimg8);
    	Bitmap bitmap = BitmapFactory.decodeStream(imageStream);
    	storeImage(bitmap,uid,"_IMGFinger8");
    	values.put(KEY_FPDATA8, fingerprint8);
    		
    	}
    	if(fingerprint9!=null)
    	{	writeminotia(fingerprint9,"/sdcard/EnrollementData/"+ uid + "/"+uid+"_Finger9");
    	ByteArrayInputStream imageStream = new ByteArrayInputStream(fpimg9);
    	Bitmap bitmap = BitmapFactory.decodeStream(imageStream);
    	storeImage(bitmap,uid,"_IMGFinger9");
    	values.put(KEY_FPDATA9, fingerprint9);
    }		
    	if(fingerprint10!=null)
    	{writeminotia(fingerprint10,"/sdcard/EnrollementData/"+ uid + "/"+uid+"_Finger10");
    	ByteArrayInputStream imageStream = new ByteArrayInputStream(fpimg10);
    	Bitmap bitmap = BitmapFactory.decodeStream(imageStream);
    	storeImage(bitmap,uid,"_IMGFinger10");
    	values.put(KEY_FPDATA10, fingerprint10);
    }
    	
       if(userImage!=null){
    	ByteArrayInputStream imageStream = new ByteArrayInputStream(userImage);
 	   Bitmap bitmap = BitmapFactory.decodeStream(imageStream);
 	   storeImage(bitmap,uid,"_IMGUser");
 	   values.put(KEY_IMGDATA, userImage);
       }
 	   
    	  // ContentValues updateValues = createContentValuesUpdateUser( fname, lname, dob,phoneno, country, nationality, city, sex,fingerprint,fingerprint2,fingerprint3,fingerprint4,fingerprint5,fingerprint6,fingerprint7,fingerprint8,fingerprint9,fingerprint10,userImage);

    	  
    	   db.update(table_name, values, KEY_UID+"="+uid+"", null);
 
    	   Toast.makeText(this, "User Information Updated successfully", Toast.LENGTH_SHORT).show();
         
    	   fingerprint=null;fingerprint2=null;fingerprint3=null;fingerprint4=null;fingerprint5=null;fingerprint6=null;fingerprint7=null; fingerprint8=null;fingerprint9=null;fingerprint10=null;
    	   return "updateUserOK";
    }
//public void Insert(String uid,String passwd, String fname, String lname,String dob ,String did ,byte[] fpdata)
public int Insert(String uid,String passwd, String fname, String lname,String dob ,String phoneno ,String country,String nationality ,String city ,String sex)
{
	File mediaStorageDir = new File(Environment.getExternalStorageDirectory()
            + "/EnrollementData/" + uid);
	if (! mediaStorageDir.exists()){
        if (! mediaStorageDir.mkdirs()){
           // return null;
        }
    } 
	else
	{
		File[] files = mediaStorageDir.listFiles();
	    if(files!=null) { //some JVMs return null for empty dirs
	        for(File f: files) {
	            if(f.isDirectory()) {
	               continue;
	            } else {
	                f.delete();
	            }
	        }
	    }
	    mediaStorageDir.delete();
	}
	
	
	if(fingerprint!=null)
	{	writeminotia(fingerprint,"/sdcard/EnrollementData/"+ uid + "/"+uid+"_Finger1");
		ByteArrayInputStream imageStream = new ByteArrayInputStream(fpimg1);
		Bitmap bitmap = BitmapFactory.decodeStream(imageStream);
		storeImage(bitmap,uid,"_IMGFinger1");
	}		
	if(fingerprint2!=null)
	{	writeminotia(fingerprint2,"/sdcard/EnrollementData/"+ uid + "/"+uid+"_Finger2");
		ByteArrayInputStream imageStream = new ByteArrayInputStream(fpimg2);
		Bitmap bitmap = BitmapFactory.decodeStream(imageStream);
		storeImage(bitmap,uid,"_IMGFinger2");
	}		
	if(fingerprint3!=null)
		{writeminotia(fingerprint3,"/sdcard/EnrollementData/"+ uid + "/"+uid+"_Finger3");
	ByteArrayInputStream imageStream = new ByteArrayInputStream(fpimg3);
	Bitmap bitmap = BitmapFactory.decodeStream(imageStream);
	storeImage(bitmap,uid,"_IMGFinger3");
}		
	if(fingerprint4!=null)
		{writeminotia(fingerprint4,"/sdcard/EnrollementData/"+ uid + "/"+uid+"_Finger4");
		ByteArrayInputStream imageStream = new ByteArrayInputStream(fpimg4);
		Bitmap bitmap = BitmapFactory.decodeStream(imageStream);
		storeImage(bitmap,uid,"_IMGFinger4");
	}		
	if(fingerprint5!=null)
		{writeminotia(fingerprint5,"/sdcard/EnrollementData/"+ uid + "/"+uid+"_Finger5");
		ByteArrayInputStream imageStream = new ByteArrayInputStream(fpimg5);
		Bitmap bitmap = BitmapFactory.decodeStream(imageStream);
		storeImage(bitmap,uid,"_IMGFinger5");
	}		
		
	if(fingerprint6!=null)
	{	writeminotia(fingerprint6,"/sdcard/EnrollementData/"+ uid + "/"+uid+"_Finger6");
	ByteArrayInputStream imageStream = new ByteArrayInputStream(fpimg6);
	Bitmap bitmap = BitmapFactory.decodeStream(imageStream);
	storeImage(bitmap,uid,"_IMGFinger6");
}		
	if(fingerprint7!=null)
	{	writeminotia(fingerprint7,"/sdcard/EnrollementData/"+ uid + "/"+uid+"_Finger7");
	ByteArrayInputStream imageStream = new ByteArrayInputStream(fpimg7);
	Bitmap bitmap = BitmapFactory.decodeStream(imageStream);
	storeImage(bitmap,uid,"_IMGFinger7");
}		
	if(fingerprint8!=null)
	{	writeminotia(fingerprint8,"/sdcard/EnrollementData/"+ uid + "/"+uid+"_Finger8");
	ByteArrayInputStream imageStream = new ByteArrayInputStream(fpimg8);
	Bitmap bitmap = BitmapFactory.decodeStream(imageStream);
	storeImage(bitmap,uid,"_IMGFinger8");
		
	}
	if(fingerprint9!=null)
	{	writeminotia(fingerprint9,"/sdcard/EnrollementData/"+ uid + "/"+uid+"_Finger9");
	ByteArrayInputStream imageStream = new ByteArrayInputStream(fpimg9);
	Bitmap bitmap = BitmapFactory.decodeStream(imageStream);
	storeImage(bitmap,uid,"_IMGFinger9");
}		
	if(fingerprint10!=null)
		{writeminotia(fingerprint10,"/sdcard/EnrollementData/"+ uid + "/"+uid+"_Finger10");
	ByteArrayInputStream imageStream = new ByteArrayInputStream(fpimg10);
	Bitmap bitmap = BitmapFactory.decodeStream(imageStream);
	storeImage(bitmap,uid,"_IMGFinger10");
}		
		
   ContentValues data=createContentValues(uid,passwd,fname,lname,dob, phoneno , country, nationality , city , sex,fingerprint,fingerprint2,fingerprint3,fingerprint4,fingerprint5,fingerprint6,fingerprint7,fingerprint8,fingerprint9,fingerprint10,userImage);
   db.insert(table_name, null, data);

   Toast.makeText(this, "User Registered Successfully", Toast.LENGTH_SHORT).show();
   
   //byte[] imageAsBytes = Base64.decodeTobytes(userImage, Base64.DEFAULT);
   ByteArrayInputStream imageStream = new ByteArrayInputStream(userImage);
   Bitmap bitmap = BitmapFactory.decodeStream(imageStream);
   storeImage(bitmap,uid,"_IMGUser");
   
   
   fingerprint=null;fingerprint2=null;fingerprint3=null;fingerprint4=null;fingerprint5=null;fingerprint6=null;fingerprint7=null; fingerprint8=null;fingerprint9=null;fingerprint10=null;
   return 1;
}


private void storeImage(Bitmap image,String Uid,String ImgName) {
    File pictureFile = getOutputMediaFile(Uid,ImgName);
    if (pictureFile == null) {
        Log.d(TAG,
                "Error creating media file, check storage permissions: ");// e.getMessage());
        return;
    } 
    try {
        FileOutputStream fos = new FileOutputStream(pictureFile);
        image.compress(Bitmap.CompressFormat.PNG, 90, fos);
        fos.close();
    } catch (FileNotFoundException e) {
        Log.d(TAG, "File not found: " + e.getMessage());
    } catch (IOException e) {
        Log.d(TAG, "Error accessing file: " + e.getMessage());
    }  
}


private  File getOutputMediaFile(String idu,String ImgName){
    // To be safe, you should check that the SDCard is mounted
    // using Environment.getExternalStorageState() before doing this. 
   // File mediaStorageDir = new File(Environment.getExternalStorageDirectory()
    //        + "/Android/data/EnrollementData/images");
	File mediaStorageDir = new File(Environment.getExternalStorageDirectory()
            + "/EnrollementData/" + idu +"/");
	
           // + getApplicationContext().getPackageName()
            //+ "/images"); 

    // This location works best if you want the created images to be shared
    // between applications and persist after your app has been uninstalled.

    // Create the storage directory if it does not exist
    if (! mediaStorageDir.exists()){
        if (! mediaStorageDir.mkdirs()){
            return null;
        }
    } 
    // Create a media file name
   // String timeStamp = new SimpleDateFormat("ddMMyyyy_HHmm").format(new Date());
    File mediaFile;
        String mImageName=idu+ImgName+".bmp";
        mediaFile = new File(mediaStorageDir.getPath() + File.separator + mImageName);  
    return mediaFile;
} 

public void Insertlogdata(String puid, String pdate, String ptime)

{

   ContentValues data=createContentValueslogdata(puid,pdate,ptime);

   db1.insert(table_name1, null, data);

   //Toast.makeText(this, "Record Log Inserted", Toast.LENGTH_SHORT).show();

}



// updating record in the database

public void UpdateDeviceSetting(String eqs,String iqs,String vqs,String sls,String dtos,String bris,String contrs,String gainset,String postt)

{

   ContentValues updateValues = createContentValuesUpdateDeviceSetting( eqs, iqs, vqs, sls, dtos, bris, contrs, gainset, postt);

   db2.update(table_name2, updateValues, KEY_SETID+"= 1", null);

   Toast.makeText(this, "New Setting Saved", Toast.LENGTH_SHORT).show();

}



// deleting record rom the database

public void Delete(int uid)
{
	File mediaStorageDir = new File(Environment.getExternalStorageDirectory()
            + "/EnrollementData/" + uid);
	if (! mediaStorageDir.exists()){
        if (! mediaStorageDir.mkdirs()){
           // return null;
        }
    } 
	else
	{
		File[] files = mediaStorageDir.listFiles();
	    if(files!=null) { //some JVMs return null for empty dirs
	        for(File f: files) {
	            if(f.isDirectory()) {
	               continue;
	            } else {
	                f.delete();
	            }
	        }
	    }
	    mediaStorageDir.delete();
	}
   db.delete(table_name, KEY_UID+"="+uid, null);
   Toast.makeText(this, "Record Deleted", Toast.LENGTH_SHORT).show();
}

public void DeleteALL(int uid)
{
   db.delete(table_name, KEY_UID+"="+uid, null);
   Toast.makeText(this, "Record Deleted", Toast.LENGTH_SHORT).show();
}

public void DeleteMasterNormal(int privel)
{
   db.delete(table_name, KEY_UID+"="+privel, null);
   Toast.makeText(this, "Record Deleted", Toast.LENGTH_SHORT).show();
}



// return a content of the database

private ContentValues createContentValuesAdminData(String adminId,String adminUser,String adminPasswd,String adminFname,String adminLname,String adminContact,String adminEmail)     
{

          ContentValues values = new ContentValues();
          values.put(KEY_ADMINID, adminId);
          values.put(KEY_ADMINUSER, adminUser);
          values.put(KEY_ADMINPWD, adminPasswd);
          values.put(KEY_ADMINFNAME, adminFname);
          values.put(KEY_ADMINLNAME, adminLname);
          values.put(KEY_ADMINCONTACT ,adminContact);
          values.put(KEY_ADMINEMAIL ,adminEmail);
          return values;

}

private ContentValues createContentValuesUpdateAdminUser(String adminUser,String adminPasswd,String adminFname,String adminLname,String adminContact)
{
	ContentValues values = new ContentValues();
	values.put(KEY_ADMINUSER, adminUser);
    values.put(KEY_ADMINPWD, adminPasswd);
    values.put(KEY_ADMINFNAME, adminFname);
    values.put(KEY_ADMINLNAME, adminLname);
    values.put(KEY_ADMINCONTACT ,adminContact);
    //values.put(KEY_ADMINEMAIL ,adminEmail);
	return values;
}

private ContentValues createContentValues(String uid,String passwd, String fname, String lname,String dob ,String phoneno ,String country,String nationality ,String city ,String sex,byte[] fpdata,byte[] fpdata2,byte[] fpdata3,byte[] fpdata4,byte[] fpdata5,byte[] fpdata6,byte[] fpdata7,byte[] fpdata8,byte[] fpdata9,byte[] fpdata10,byte[] imgdata )     
{

          ContentValues values = new ContentValues();

          values.put(KEY_UID, uid);
          values.put(KEY_PASSWD, passwd);
          values.put(KEY_FNAME, fname);
          values.put(KEY_LNAME, lname);
          values.put(KEY_DOB, dob);
          //values.put(KEY_DPART, did);
          
          values.put(KEY_PHONENO ,phoneno);
          values.put( KEY_COUNTRY ,country);
          values.put( KEY_NATIONALITY,nationality); 
          values.put( KEY_CITY ,city);
          values.put( KEY_SEX ,sex);
          
          values.put(KEY_FPDATA, fpdata);
          values.put(KEY_FPDATA2, fpdata2);
          values.put(KEY_FPDATA3, fpdata3);
          values.put(KEY_FPDATA4, fpdata4);
          values.put(KEY_FPDATA5, fpdata5);
          values.put(KEY_FPDATA6, fpdata6);
          values.put(KEY_FPDATA7, fpdata7);
          values.put(KEY_FPDATA8, fpdata8);
          values.put(KEY_FPDATA9, fpdata9);
          values.put(KEY_FPDATA10, fpdata10);
          
          values.put(KEY_IMGDATA, imgdata);
          return values;

}
	
private ContentValues createContentValueslogdata(String puid, String pdate, String ptime)     
{

          ContentValues values = new ContentValues();

          values.put(KEY_PUID, puid);
          values.put(KEY_PDATE, pdate);
          values.put(KEY_PTIME, ptime);
         
          return values;

}
	

private ContentValues createContentValuesSettingData(String eqs,String iqs,String vqs,String sls,String dtos,String bris,String contrs,String gainset,String postt)
{
	ContentValues values = new ContentValues();
		     
	values.put(KEY_EQS , eqs);
	values.put(KEY_IQS , iqs);
	values.put(KEY_VQS , vqs);
	values.put(KEY_SLS , sls);
	values.put(KEY_DTOS , dtos);
	values.put(KEY_BRIS , bris);
	values.put(KEY_CONTRS , contrs);
	values.put(KEY_GAINSET , gainset);
	values.put(KEY_POSTT , postt);

	return values;
}


private ContentValues createContentValuesUpdateDeviceSetting(String eqs,String iqs,String vqs,String sls,String dtos,String bris,String contrs,String gainset,String postt)
{
	ContentValues values = new ContentValues();
	
	values.put(KEY_EQS , eqs);
	values.put(KEY_IQS , iqs);
	values.put(KEY_VQS , vqs);
	values.put(KEY_SLS , sls);
	values.put(KEY_DTOS , dtos);
	values.put(KEY_BRIS , bris);
	values.put(KEY_CONTRS , contrs);
	values.put(KEY_GAINSET , gainset);
	values.put(KEY_POSTT , postt);
	return values;
}



private ContentValues createContentValuesUpdateUser(String fname,String lname,String dob,String phoneno,String country,String nationality,String city,String sex,byte[] fpdata,byte[] fpdata2,byte[] fpdata3,byte[] fpdata4,byte[] fpdata5,byte[] fpdata6,byte[] fpdata7,byte[] fpdata8,byte[] fpdata9,byte[] fpdata10,byte[] imgdata )
{
	ContentValues values = new ContentValues();
	
	
    values.put(KEY_FNAME, fname);
    values.put(KEY_LNAME, lname);
    values.put(KEY_DOB, dob);
    //values.put(KEY_DPART, did);
    
    values.put(KEY_PHONENO ,phoneno);
    values.put( KEY_COUNTRY ,country);
    values.put( KEY_NATIONALITY,nationality); 
    values.put( KEY_CITY ,city);
    values.put( KEY_SEX ,sex);
    
    values.put(KEY_FPDATA, fpdata);
    values.put(KEY_FPDATA2, fpdata2);
    values.put(KEY_FPDATA3, fpdata3);
    values.put(KEY_FPDATA4, fpdata4);
    values.put(KEY_FPDATA5, fpdata5);
    values.put(KEY_FPDATA6, fpdata6);
    values.put(KEY_FPDATA7, fpdata7);
    values.put(KEY_FPDATA8, fpdata8);
    values.put(KEY_FPDATA9, fpdata9);
    values.put(KEY_FPDATA10, fpdata10);
    
    values.put(KEY_IMGDATA, imgdata);
	return values;
}


static String photoString = null;
	//
	private NBioBSPJNI				bsp;
	private byte[]					byIso1;
	private byte[]					byIso2;
	private byte[]					byCapturedRaw1;
	private int						nCapturedRawWidth1;
	private int						nCapturedRawHeight1;
	private int						nCapturedRawWidth2;
	private int						nCapturedRawHeight2;
	private byte[]					byCapturedRaw2;
	private NBioBSPJNI.Export       exportEngine;
	private NBioBSPJNI.IndexSearch  indexSearch;
	private boolean					bCapturedFirst;
	private NBioBSPJNI.DEVICE_INFO  obdevinfo;
	private NBioBSPJNI.INIT_INFO_0  objinitinfo;
	public static final int QUALITY_LIMIT = 80;
	
	private static final int CAMERA_REQUEST = 1;
	private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 1337; 
	public static int rval = 0;
	DialogFragment sampleDialogFragment;
	private boolean					bAutoOn = false;
	
	private NBioBSPJNI.IndexSearch.SAMPLE_INFO sampleInfo;
	
	String AUResultSTR = "NO_DATA";
	/** NITGEN SDK Capture Callback method */
	public int OnCaptured(CAPTURED_DATA capturedData)
	{
		String msg;
	
		if(capturedData.getImageQuality()>=QUALITY_LIMIT){
    		if(sampleDialogFragment!=null)
    			sampleDialogFragment.dismiss();
    		return NBioBSPJNI.ERROR.NBioAPIERROR_USER_CANCEL;
    	}else if(capturedData.getDeviceError()!=NBioBSPJNI.ERROR.NBioAPIERROR_NONE){
    		if(sampleDialogFragment!=null)
    			sampleDialogFragment.dismiss();
    		return capturedData.getDeviceError();
    	}else{
    		return NBioBSPJNI.ERROR.NBioAPIERROR_NONE;    		
    	}
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
    	/// new add
    	
    	db = openOrCreateDatabase(database_name , SQLiteDatabase.CREATE_IF_NECESSARY,null);

        db.setVersion(1);

        db.setLocale(Locale.getDefault());

        db.setLockingEnabled(true);

       
        db1 = openOrCreateDatabase(database_name , SQLiteDatabase.CREATE_IF_NECESSARY,null);

        db1.setVersion(1);

        db1.setLocale(Locale.getDefault());

        db1.setLockingEnabled(true);
        
        
        db2 = openOrCreateDatabase(database_name , SQLiteDatabase.CREATE_IF_NECESSARY,null);

        db2.setVersion(1);

        db2.setLocale(Locale.getDefault());

        db2.setLockingEnabled(true);
        
        
        db3 = openOrCreateDatabase(database_name , SQLiteDatabase.CREATE_IF_NECESSARY,null);

        db3.setVersion(1);

        db3.setLocale(Locale.getDefault());

        db3.setLockingEnabled(true);
        
        
        // creating table in database

        db.execSQL("CREATE TABLE IF NOT EXISTS "+table_name+" " +

                        "( sid INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "  uid INTEGER," +
                        "  passwd INTEGER," +
                        "  fname TEXT," +
                        "  lname TEXT," +
                        "  dob TEXT," +
                        "  phoneno INTEGER," + 
                        "  country TEXT," +
                        "  nationality TEXT," +
                        "  city TEXT," +
                        "  sex TEXT," +
                        "  fpdata BLOB," +
                        "  fpdata2 BLOB," +
                        "  fpdata3 BLOB," +
                        "  fpdata4 BLOB," +
                        "  fpdata5 BLOB," +
                        "  fpdata6 BLOB," +
                        "  fpdata7 BLOB," +
                        "  fpdata8 BLOB," +
                        "  fpdata9 BLOB," +
                        "  fpdata10 BLOB," +
                        "  imgdata BLOB); ");
    	
    	
        db1.execSQL("CREATE TABLE IF NOT EXISTS "+table_name1+" " +

                        "( pcid INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "  puid INTEGER," +
                        "  pdate TEXT," +
                        "  ptime TEXT); ");
        
        db2.execSQL("CREATE TABLE IF NOT EXISTS "+table_name2+" " +
        			
        		"( setid INTEGER PRIMARY KEY AUTOINCREMENT," +
        		"  eqs INTEGER," +
        		"  iqs INTEGER," +
        		"  vqs INTEGER," +
        		"  sls INTEGER," +
        		"  dtos INTEGER," +
        		"  bris INTEGER," +
        		"  contrs INTEGER," +
        		"  gainset INTEGER," +
        		"  postt INTEGER);");
        
        db3.execSQL("CREATE TABLE IF NOT EXISTS "+table_name3+" " +

                "( adminId INTEGER PRIMARY KEY AUTOINCREMENT," +
                "  adminUser TEXT," +
                "  adminPasswd TEXT," +
                "  adminFname TEXT," +
                "  adminLname TEXT," +
                "  adminContact TEXT," + 
                "  adminEmail TEXT); ");
    	// new add
    	
    	       
        
        super.onCreate(savedInstanceState);
        super.init();
        Tas_Plugin myPlugin = new Tas_Plugin(this, appView);        
        appView.addJavascriptInterface(myPlugin, "Tas_Plugin");
        super.loadUrl("file:///android_asset/www/login.html");
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

	    //int UserID=0;
    	//UserID=1001+getLastId();
        if(defaultsettingentry()<=0)
        {
        	InsertDeviceSetting("50","30","30","5","10000","40","40","3","10");
        }
        
        if(countAdminUser()<=0)
        {
        	InsertAdminData("1","admin","1234","Admin","User","9191919191","admin@bioenabletech.com");
        }
    	 
        
        NBioBSPJNI.CURRENT_PRODUCT_ID = 0;
    	if(bsp==null){    	
    		bsp = new NBioBSPJNI("010701-613E5C7F4CC7C4B0-72E340B47E034015", this);
    		String msg = null;
    		if (bsp.IsErrorOccured())
    			msg = "NBioBSP Error: " + bsp.GetErrorCode();
    		else  {
    			msg = "SDK Version: " + bsp.GetVersion();
    			exportEngine = bsp.new Export();
    			indexSearch = bsp.new IndexSearch();
    			obdevinfo = bsp.new DEVICE_INFO();
    		}
    		
    	}       
    	//OnBtnOpenDevice();
    	sampleDialogFragment = new SampleDialogFragment();
    	//OnBtnOpenDevice();
    } 

    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.activity_android__demo, menu);
        return true;
    }
    
    
    //To get IMEI no.  
    public String getIMEI(){
    	TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
    	String imei = tm.getDeviceId();
    	Toast.makeText(this,"This is IMEI" + imei, Toast.LENGTH_SHORT).show();
        return imei;
    }
    
    //To get mac ID
    public String getMacID()
    {
    	String macAddr,wifiStatus;
    
    	WifiManager wifiMan = (WifiManager) this.getSystemService(Context.WIFI_SERVICE);
    	WifiInfo wifiInf = wifiMan.getConnectionInfo();
    	
    	ConnectivityManager connManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
    	NetworkInfo mWifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

    	if (mWifi.isConnected()) {
    		wifiStatus ="Connected";
    	}else{wifiStatus = "Disconnected";}
    	
    	int ipAddress = wifiInf.getIpAddress();
        
        String WifiIpAdd =String.format("%d.%d.%d.%d",
        		(ipAddress & 0xff),
        		(ipAddress >> 8 & 0xff),
        		(ipAddress >> 16 & 0xff),
        		(ipAddress >> 24 & 0xff));
    	
    	return macAddr = wifiStatus + " " + wifiInf.getMacAddress() +" " + WifiIpAdd + " " + wifiInf.getSSID();
    }
    
    //Display Batery Level
    public float getBatteryLevel() {
        Intent batteryIntent = registerReceiver(null, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        int level = batteryIntent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int scale = batteryIntent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);

        // Error checking that probably isn't needed but I added just in case.
        if(level == -1 || scale == -1) {
            return 50.0f;
        }
        return ((float)level / (float)scale) * 100.0f; 
    }
    
    //Function for connecting to internet
    public String getConnectingToInternet(){
        ConnectivityManager connectivity = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
          if (connectivity != null)
          {
              NetworkInfo[] info = connectivity.getAllNetworkInfo();
              if (info != null)
                  for (int i = 0; i < info.length; i++)
                      if (info[i].getState() == NetworkInfo.State.CONNECTED)
                      {
                          return "ON";
                      }
 
          }
          return "OFF";
    }
    
    //Display setting screen
    public void ShowSettingScreen()
    {
    	final Intent intent = new Intent(Intent.ACTION_MAIN, null);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        final ComponentName cn = new ComponentName("com.android.settings", "com.android.settings");
        intent.setComponent(cn);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity( intent);
    }
    
    public int NetworkSetting(int callType)
    {
    	//Intent intent = new Intent(Intent.ACTION_MAIN);
    	//intent.setClassName("com.android.phone", "com.android.phone.NetworkSetting");
    	//startActivity(intent);
    	
    	// callTpye 0 for information 1 for action 
    	
    	WifiManager wifiManager = (WifiManager) this.getSystemService(Context.WIFI_SERVICE);
    	if(callType == 0)
    	{
    		if(wifiManager.isWifiEnabled()){return 1;}else{return 0;}
    	}
    	else
    	{
    		 if(wifiManager.isWifiEnabled()){
    	     wifiManager.setWifiEnabled(false);
    	     return 0;
    	    }else
    	    {
    	     wifiManager.setWifiEnabled(true);
    	     return 1;
    	    }
    	}
    }
    
    public void callCamera()
    {
    	Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE); 
        startActivityForResult(cameraIntent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE); 
        
        //Toast.makeText(this, photoString, Toast.LENGTH_SHORT).show();
    }
    
    public String Photostrdata()
    {
    	return photoString;
    }
    
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {  
       
    	if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
    		   if (resultCode == RESULT_OK) {
    			   Bitmap  photo = (Bitmap) data.getExtras().get("data"); 
    		          //imageView.setImageBitmap(photo);
    		          ByteArrayOutputStream baos = new ByteArrayOutputStream();  
    		          photo.compress(Bitmap.CompressFormat.PNG, 100, baos); //bm is the bitmap object   
    		      		byte[] b = baos.toByteArray();
    		      			
    		      	//to encode base64 from byte array use following method
    		      		userImage = b;
    		      		
    		      	photoString = Base64.encodeToString(b, Base64.DEFAULT); 
    		      	
    		      	//deleteLatestImage();	
    		   } 
    		   else if (resultCode == RESULT_CANCELED) {
    		            // User cancelled the image capture
    		   } 
    		   else {
    		            // Image capture failed, advise user
    		   }
    		}
    	
    	
    	/*if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {  
          Bitmap  photo = (Bitmap) data.getExtras().get("data"); 
          //imageView.setImageBitmap(photo);
          ByteArrayOutputStream baos = new ByteArrayOutputStream();  
          photo.compress(Bitmap.CompressFormat.PNG, 100, baos); //bm is the bitmap object   
      		byte[] b = baos.toByteArray();

      	//to encode base64 from byte array use following method

      	photoString = Base64.encodeToString(b, Base64.DEFAULT);   
      	
        }  */
    }
    
    
    private void deleteLatestImage() {
        // TODO Auto-generated method stub
        File f = new File(Environment.getExternalStorageDirectory() + "/DCIM/Camera" );

        //Log.i("Log", "file name in delete folder :  "+f.toString());
        File [] files = f.listFiles();

        //Log.i("Log", "List of files is: " +files.toString());
        Arrays.sort( files, new Comparator<Object>()
                {
            public int compare(Object o1, Object o2) {

                if (((File)o1).lastModified() > ((File)o2).lastModified()) {
                    //         Log.i("Log", "Going -1");
                    return -1;
                } else if (((File)o1).lastModified() < ((File)o2).lastModified()) {
                    //     Log.i("Log", "Going +1");
                    return 1;
                } else {
                    //     Log.i("Log", "Going 0");
                    return 0;
                }
            }

                });
        //Log.i("Log", "Count of the FILES AFTER DELETING ::"+files[0].length());
        files[0].delete();

    }
    
    public String DeviceSetFrmDB()
    {
    	 String Seting_Result = "";
    	 Cursor c = db.rawQuery("SELECT eqs,iqs,vqs,sls,dtos,bris,contrs,gainset,postt FROM deviceset where setid='1'", null);
    	  
    	  String seqs= null;
    	  String siqs= null;
    	  String svqs= null;
    	  String ssls= null;
    	  String sdtos= null;
    	  String sbris= null;
    	  String scontrs= null;
    	  String sgainset= null;
    	  String spostt= null;
    	 
if (c != null ) {
     if  (c.moveToFirst()) {
           do {
        	   seqs = c.getString(c.getColumnIndex("eqs"));
        	   siqs = c.getString(c.getColumnIndex("iqs"));
        	   svqs = c.getString(c.getColumnIndex("vqs"));
        	   ssls = c.getString(c.getColumnIndex("sls"));
        	   sdtos = c.getString(c.getColumnIndex("dtos"));
        	   sbris = c.getString(c.getColumnIndex("bris"));
        	   scontrs = c.getString(c.getColumnIndex("contrs"));
        	   sgainset = c.getString(c.getColumnIndex("gainset"));
        	   spostt = c.getString(c.getColumnIndex("postt"));
        	   Seting_Result = seqs + " " + siqs + " " + svqs + " " + ssls + " " + sdtos + " " + sbris + " " + scontrs + " " + sgainset + " " + spostt;
           }while (c.moveToNext());
           
     }
	}
     return Seting_Result;
}
    public void InitInfo()
    {
    	String msg=" ";
    	INIT_INFO_0 initInfo0=null;
		bsp.GetInitInfo(initInfo0);
        
		if (bsp.IsErrorOccured())  {
        	msg = "NBioBSP OpenDevice Error: " + bsp.GetErrorCode();
        	
        	
        }
        else  {
        	msg = "Device Open Success";
	       
	    }
   
         //Get NBioAPI initial information.
        

        //if (NBioAPIERROR_NONE == nRet)  {
            //ui->editEIQ->setText(QString("%1").arg(init_info0.EnrollImageQuality));
           // ui->editVIQ->setText(QString("%1").arg(init_info0.VerifyImageQuality));
           // ui->editMEF->setText(QString("%1").arg(init_info0.MaxFingersForEnroll));
           // ui->editSPF->setText(QString("%1").arg(init_info0.SamplesPerFinger));
           // ui->editDTO->setText(QString("%1").arg(init_info0.DefaultTimeout));
           // ui->comboSL->setCurrentIndex(init_info0.SecurityLevel - 1);
      //  }

       // return nRet;
    }

    @SuppressWarnings("deprecation")
	public void SetInfo1()
    {
    	//NBioBSPJNI.DEVICE_INFO devinfOBJ = bsp.new DEVICE_INFO();
    	//obdevinfo = bsp.new DEVICE_INFO();
    	//bsp.GetDeviceInfo(obdevinfo);
    	//devinfOBJ.Brightness = 60;
    	//devinfOBJ.Contrast =60;
    	//devinfOBJ.Gain=1;
    	//int retVal = ;
    	//bsp.GetDeviceInfo(obdevinfo);
    	//Toast.makeText(this, obdevinfo.Gain, Toast.LENGTH_SHORT).show();
    	bsp.GetDeviceInfo(obdevinfo);
    	Toast.makeText(this, obdevinfo.Gain, Toast.LENGTH_SHORT).show();
    	
    	
     
    } 
       
    public void SetInfo2()
    {
    	INIT_INFO_0 initInfo0=null;
		bsp.GetInitInfo(initInfo0);
       
       /*objinitinfo.EnrollImageQuality = 50;
       objinitinfo.IdentifyImageQuality = 40;
       objinitinfo.VerifyImageQuality = 40 ;
       objinitinfo.DefaultTimeout = 10000;
       objinitinfo.SecurityLevel = 5;*/
       
	//bsp.GetInitInfo(objinitinfo);
	       String msg;
		if (bsp.IsErrorOccured())  {
        	msg = "NBioBSP OpenDevice Error: " + bsp.GetErrorCode();
               	
        }
        else  {
        	msg = "Setting set2";
        	Toast.makeText(this, initInfo0.SecurityLevel, Toast.LENGTH_SHORT).show();
	    }
        
     } 
    @Override
    public void onDestroy()
    {
    	super.onDestroy();
    	
        if (bsp != null) {
            bsp.dispose();
            bsp = null;
        }
    }
    
    public int OnBtnOpenDevice()
    {
    	
    	//if()
    	//RunAsRoot();
    	//RunAsRoot1();
    	//if (bsp.GetOpenedDeviceID() != NBioBSPJNI.DEVICE_ID.NONE)
    	//bsp.CloseDevice();
    	///p//
    	//if(bsp==null){    	
    		//bsp = new NBioBSPJNI()//("010701-613E5C7F4CC7C4B0-72E340B47E034015", this);
    	//}
    	
    	
    	String msg;
    	sampleDialogFragment.show(getFragmentManager(), "DIALOG_TYPE_PROGRESS");
    	bsp.CloseDevice();
    	 bsp.OpenDevice();
    	
    	if(sampleDialogFragment!=null)
			{
    		sampleDialogFragment.dismiss();
		rval = 1;
		}
    	 if (bsp.IsErrorOccured())  {
        	msg = "NBioBSP OpenDevice Error: " + bsp.GetErrorCode();
        	rval = 0;
          }
        else  {
        	msg = "Device Open Success";
	        rval = 1;
	    }
        
        //Toast.makeText(this, msg, Toast.LENGTH_SHORT).show(); 
        return rval;
    }
   
  public int exitApplication()
  {

	  int rval;
	  String msg;
	  bsp.CloseDevice();
    
	  if (bsp.IsErrorOccured())  {
		  msg = "NBioBSP CloseDevice Error: " + bsp.GetErrorCode();
		  rval = 0;
        	}
      else  {
    	  msg = "Device Close Success";
    	  rval = 1;
	        }
	  //Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
	  finish();
	  System.exit(0);
	  //onDestroy();
	  return rval;
  }
    
  public int OnBtnCloseDevice()
  {
	  int rval;
	  String msg;
	  bsp.CloseDevice();
    
	  if (bsp.IsErrorOccured())  {
		  msg = "NBioBSP CloseDevice Error: " + bsp.GetErrorCode();
		  rval = 0;
        	}
      else  {
    	  msg = "Application Logout Success";
    	  rval = 1;
	        }
	 // Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
	  //finish();
	  //System.exit(0);
	  //onDestroy();
	  return rval;
  }
    
    
    public void    KillStatusBar() throws IOException
    {
       Process proc = null;

        String ProcID = "79"; //HONEYCOMB AND OLDER

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH){
            ProcID = "42"; //ICS AND NEWER
        }

        try {
            proc = Runtime
                    .getRuntime()
                    .exec(new String[] { "su", "-c",
                            "service call activity "+ProcID+" s16 com.android.systemui" });
        } catch (IOException e) {
            Log.w(TAG,"Failed to kill task bar (1).");
            e.printStackTrace();
        }
        try {
            proc.waitFor();
        } catch (InterruptedException e) {
            Log.w(TAG,"Failed to kill task bar (2).");
            e.printStackTrace();
        }
    	    	
    }
    
    public void StartStatusBar() throws IOException
    {
    	Process mSuProcess;  mSuProcess = Runtime.getRuntime().exec("su"); 
    	mSuProcess = Runtime.getRuntime().exec("am startservice -n com.android.systemui/.SystemUIService");
    	OnBtnCloseDevice();
    }
    
    public void SetSystemRW()throws IOException
    {
    	Process pstm = null;
    	//pstm = Runtime.getRuntime().exec("su"); 
    	pstm = Runtime.getRuntime().exec("mount -o remount rw /system");
    }
    
    public int getLastId() {
    	Cursor c = db.rawQuery("SELECT max(sid) as msid FROM emploeeinfo", null);
    	int SID=0;
    	if (c != null ) {
    	     if  (c.moveToFirst()) {
    	           do {
    	        	   //String firstName = c.getString(c.getColumnIndex("FirstName"));
    	        	   SID = c.getInt(c.getColumnIndex("msid"));
    	        	    	           
    	           }while (c.moveToNext());
    	          
    	     }
    	    
    	}
    	
    	 return SID;
    }
    
    public void OnBtnAllLogs(View target)
    {
    	//Toast.makeText(this, "All Logs", Toast.LENGTH_SHORT).show();
    	
    	// String[] items={"UserID    Log Date-Time","","",""};
    	String[] items= new String[500]; 
    	items[0]="UserID    Log Date-Time";
    	String log;
    	
    	Cursor c = db1.rawQuery("SELECT puid,pdate,ptime FROM logdata", null);
    	
    	int SID=1;
    	if (c != null ) {
    	     if  (c.moveToFirst()) {
    	           do {
    	        	   
    	        	   String PUserID = c.getString(c.getColumnIndex("puid"));
    	        	   String PDate = c.getString(c.getColumnIndex("pdate"));
    	        	   String PTime = c.getString(c.getColumnIndex("ptime"));
    	        	   //SID = c.getInt(c.getColumnIndex("msid"));
    	        	   log=PUserID+"     "+PDate+"   "+PTime;
    	        	   items[SID]=log;
    	        	   SID=SID+1;
    	           }while (c.moveToNext());
    	           
    	           //Toast.makeText(this, log, Toast.LENGTH_SHORT).show();
    	           	
    	           //ListView gv = (ListView) findViewById(R.id.listView1);

      	       		ArrayAdapter<String> aa = new ArrayAdapter<String>(
      	       				this,
      	       				android.R.layout.simple_list_item_1, 
      	       				items );

      	       	//	gv.setAdapter(aa);
    	          
    	     }
    	 }
    }
    
    public void OnBtnYesterdaysLogs(View target)
    {
    	//Toast.makeText(this, "All Logs", Toast.LENGTH_SHORT).show();
    	
    	String[] items= new String[500]; 
    	items[0]="UserID    Log Date-Time";
    	String log;
    	
    	Calendar cal = Calendar.getInstance();
   	 	String sDate = cal.get(Calendar.YEAR) + "-" 
			+ cal.get(Calendar.MONTH)
			+ "-" + (cal.get(Calendar.DAY_OF_MONTH)-1); 
			//Toast.makeText(this, sDate, Toast.LENGTH_SHORT).show();
    	Cursor c = db1.rawQuery("SELECT puid,pdate,ptime FROM logdata where pdate='"+sDate+"'", null);
    	
    	int SID=1;

    	if (c != null ) {
    	     if  (c.moveToFirst()) {
    	           do {
    	        	   String PUserID = c.getString(c.getColumnIndex("puid"));
    	        	   String PDate = c.getString(c.getColumnIndex("pdate"));
    	        	   String PTime = c.getString(c.getColumnIndex("ptime"));
    	        	   //SID = c.getInt(c.getColumnIndex("msid"));
    	        	   log=PUserID+"     "+PDate+"   "+PTime;
    	        	   items[SID]=log;
    	        	   SID=SID+1;
    	           }while (c.moveToNext());
    	           
    	           //Toast.makeText(this, log, Toast.LENGTH_SHORT).show();
    	           	
    	           // ListView gv = (ListView) findViewById(R.id.listView1);

   	       		ArrayAdapter<String> aa = new ArrayAdapter<String>(
   	       				this,
   	       				android.R.layout.simple_list_item_1, 
   	       				items );

   	       		//gv.setAdapter(aa);
    	          
    	     }
    	    
    	}
    }
    
    public void OnBtnTodaysLogs()
    {
    	//Toast.makeText(this, "All Logs", Toast.LENGTH_SHORT).show();
    	
    	String[] items= new String[500]; 
    	items[0]="UserID    Log Date-Time";
    	String log;
    	
    	Calendar cal = Calendar.getInstance();

		String sDate = cal.get(Calendar.YEAR) + "-" 
			+ cal.get(Calendar.MONTH)
			+ "-" + cal.get(Calendar.DAY_OF_MONTH); 
			
    	Cursor c = db1.rawQuery("SELECT puid,pdate,ptime FROM logdata where pdate='"+sDate+"'", null);
    	
    	int SID=1;
    	if (c != null ) {
    	     if  (c.moveToFirst()) {
    	           do {
    	        	   String PUserID = c.getString(c.getColumnIndex("puid"));
    	        	   String PDate = c.getString(c.getColumnIndex("pdate"));
    	        	   String PTime = c.getString(c.getColumnIndex("ptime"));
    	        	   //SID = c.getInt(c.getColumnIndex("msid"));
    	        	   log=PUserID+"     "+PDate+"   "+PTime;
    	        	   items[SID]=log;
    	        	   SID++;
    	           }while (c.moveToNext());
    	           
    	           //Toast.makeText(this, log, Toast.LENGTH_SHORT).show();
    	           	
    	       // ListView gv = (ListView) findViewById(R.id.listView1);

   	       		ArrayAdapter<String> aa = new ArrayAdapter<String>(
   	       				this,
   	       				android.R.layout.simple_list_item_1, 
   	       				items );

   	       		//gv.setAdapter(aa);
    	          
    	     }
    	    
    	}
    }
    
    public int ValidateAdminUser(String username,String password)
    {
    	String userVal= null;
    	int userP=0;
		 Cursor c = db3.rawQuery("SELECT * FROM adminuser WHERE adminUser='"+username+"' AND adminPasswd='"+password+"'", null);
    	 //
    	 if (c != null ) {
    	     if  (c.moveToFirst()) {
    	           do {
    	        	   userVal =c.getString(c.getColumnIndex("adminId"));
    	        	   if(userVal != null)
    	        		   userP=1;
    	           }while (c.moveToNext());
    	           
    	     }
    	}
    	return userP;
    	
    }
    
    public void OnBtnClose(View target)
    {
    	
    	//Toast.makeText(this, "clo", Toast.LENGTH_SHORT).show();
    	finish();
        System.exit(0);
    }
    /*
    public void OnBtnSave(View target)
    {
    	int saveflag=0;
    	//EditText editText1 = (EditText) findViewById(R.id.editText1);
    	//EditText editText2 = (EditText) findViewById(R.id.editText2);
    	//EditText editText3 = (EditText) findViewById(R.id.editText3);
    	//EditText editText4 = (EditText) findViewById(R.id.editText4);
    	
    	if (editText2.getText().toString().trim().equals("")) {
    	    Toast.makeText(this, "plz enter First Name ", Toast.LENGTH_SHORT).show();
    	    saveflag=1;
    	}
    	if (editText3.getText().toString().trim().equals("")) {
    	    Toast.makeText(this, "plz enter Last Name ", Toast.LENGTH_SHORT).show();
    	    saveflag=1;
    	}
    	if (editText4.getText().toString().trim().equals("")) {
    	    Toast.makeText(this, "plz enter DOB ", Toast.LENGTH_SHORT).show();
    	    saveflag=1;
    	}
    	if(saveflag==0)
    	{
    	Insert(editText1.getText().toString(),editText2.getText().toString(),editText3.getText().toString(),editText4.getText().toString(),"1",fingerprint);
    	
    	String filename = editText1.getText().toString() + ".txt";
    	
    //	Button btnSave = (Button) findViewById(R.id.btnSave);
    //	btnSave.setEnabled(false);
    	int UserID=0;
    	UserID=1001+getLastId();
    	//editText1.setEnabled(false);
    	// editText1.setText(Integer.toString(UserID));
    	 //View vFP = (View) findViewById(R.id.viewFP1);
			//vFP.setBackgroundDrawable(null);
			//TextView tvInfo = (TextView) findViewById(R.id.textInfo);
			//tvInfo.setText("Status :User Registration Succeed");
			
			
			//String filename = "filename.txt";
			
	    	//File file = new File(Environment.getExternalStorageDirectory(), filename);
	    	FileOutputStream fos;
	    	//byte[] data = new String("data to write to file").getBytes();
	    	try {
	    	    fos = new FileOutputStream(file);
	    	    fos.write(fingerprint,0,fingerprint.length);
	    	    fos.flush();
	    	    //fos.close();
	    	} catch (FileNotFoundException e) {
	    	    // handle exception
	    	} catch (IOException e) {
	    	    // handle exception
	    	}
			
			
			//editText2.setText("");
			//editText3.setText("");
			//editText4.setText("");
    	
    }
   */ 
    public int masterPW(int userID,int userPW)
    {
    	 int checkval=0;
    	 String verifyid=Integer.toString(userID);
    	 
    	 Cursor c = db.rawQuery("SELECT uid,passwd FROM emploeeinfo where uid='"+verifyid+"'", null);
    	 int uId, pwd;
    	
    	 if (c != null ) {
    	     if  (c.moveToFirst()) {
    	           do {
    	        	   	uId = c.getInt(c.getColumnIndex("uid"));
    	        	   	pwd = c.getInt(c.getColumnIndex("passwd"));
    	        	   	if(userID == uId && userPW == pwd)
    	        	   	{
    	        	   		checkval=1;
    	        	   	}
    	           }while (c.moveToNext());
    	           
    	     }
    	}
    	 return checkval;
    }
    
    
    public int masterPresencecheck()
    {
    	 int checkval=0;
    	 
    	 Cursor c = db.rawQuery("SELECT SUM(did) as masterchecksum FROM emploeeinfo", null);
    	 //
    	 if (c != null ) {
    	     if  (c.moveToFirst()) {
    	           do {
    	        	   checkval = c.getInt(c.getColumnIndex("masterchecksum"));
    	           }while (c.moveToNext());
    	           
    	     }
    	}
    	 return checkval;
    }
    
    public int userCount()
    {
    	 int Ucount=0;
    	 
    	 Cursor c = db.rawQuery("SELECT COUNT(*) as allusercount FROM emploeeinfo", null);
    	 //
    	 if (c != null ) {
    	     if  (c.moveToFirst()) {
    	           do {
    	        	   Ucount = c.getInt(c.getColumnIndex("allusercount"));
    	           }while (c.moveToNext());
    	           
    	     }
    	}
    	 return Ucount;
    }
    
    public int MasteruserCount()
    {
    	 int MUcount=0;
    	 
    	 Cursor c = db.rawQuery("SELECT COUNT(*) as Musercount FROM emploeeinfo where did ='1'", null);
    	 //
    	 if (c != null ) {
    	     if  (c.moveToFirst()) {
    	           do {
    	        	   MUcount = c.getInt(c.getColumnIndex("Musercount"));
    	           }while (c.moveToNext());
    	           
    	     }
    	}
    	 return MUcount;
    }
    
    public int countAdminUser()
    {
    	int Usercount=0;
    	 
    	 Cursor c = db3.rawQuery("SELECT COUNT(*) as allusercount FROM adminuser", null);
    	 //
    	 if (c != null ) {
    	     if  (c.moveToFirst()) {
    	           do {
    	        	   Usercount = c.getInt(c.getColumnIndex("allusercount"));
    	           }while (c.moveToNext());
    	           
    	     }
    	}
    	 return Usercount;
    }
    
    public int defaultsettingentry()
    {
    	 int checkval=0;
    	 
    	 Cursor c = db.rawQuery("SELECT SUM(setid) as masterchecksum FROM deviceset", null);
    	 //
    	 if (c != null ) {
    	     if  (c.moveToFirst()) {
    	           do {
    	        	   checkval = c.getInt(c.getColumnIndex("masterchecksum"));
    	           }while (c.moveToNext());
    	           
    	     }
    	}
    	 return checkval;
    }
    
    public String OnBtnVerify(int userID)
    {
   	 byte[] fpdata=null,fpdata2=null,fpdata3=null,fpdata4=null,fpdata5=null,fpdata6=null,fpdata7=null,fpdata8=null,fpdata9=null,fpdata10=null;
   	 flag=0;
   	 String Verify_Result = "No Data";
        String verifyid=Integer.toString(userID);
        Cursor c = db.rawQuery("SELECT uid,fname,lname,dob,phoneno,country,nationality,city,sex,fpdata,fpdata2,fpdata3,fpdata4,fpdata5,fpdata6,fpdata7,fpdata8,fpdata9,fpdata10,imgdata FROM emploeeinfo where uid='"+verifyid+"'", null);
        String dId = null;
        String uId = null;
        String vfname = null;
        String vlname = null;
        String vdob = null; 
        String vphoneno = null;
        String vcountry = null;
        String vnationality = null;
        String vcity = null;
        String vsex = null;
        String UserData = null;
        String ImgData = null;
        if (c != null ) {
        if  (c.moveToFirst()) {
       	 do {
       		 //String firstName = c.getString(c.getColumnIndex("FirstName"));
       		 fpdata = c.getBlob(c.getColumnIndex("fpdata"));
       		 fpdata2 = c.getBlob(c.getColumnIndex("fpdata2"));
       		 fpdata3= c.getBlob(c.getColumnIndex("fpdata3"));
       		 fpdata4 = c.getBlob(c.getColumnIndex("fpdata4"));
       		 fpdata5 = c.getBlob(c.getColumnIndex("fpdata5"));
       		  fpdata6 = c.getBlob(c.getColumnIndex("fpdata6"));
       		  fpdata7 = c.getBlob(c.getColumnIndex("fpdata7"));
       		  fpdata8 = c.getBlob(c.getColumnIndex("fpdata8"));
       		  fpdata9 = c.getBlob(c.getColumnIndex("fpdata9"));
       		  fpdata10 = c.getBlob(c.getColumnIndex("fpdata10"));
       		 byte[] imgdata = c.getBlob(c.getColumnIndex("imgdata"));
           	 //dId = c.getString(c.getColumnIndex("did")); 
           	 uId = c.getString(c.getColumnIndex("uid"));
           	 vfname = c.getString(c.getColumnIndex("fname"));
           	 vlname = c.getString(c.getColumnIndex("lname"));
           	 vdob = c.getString(c.getColumnIndex("dob"));
           	 vphoneno = c.getString(c.getColumnIndex("phoneno"));
           	 vcountry = c.getString(c.getColumnIndex("country"));
           	 vnationality = c.getString(c.getColumnIndex("nationality"));
           	 vcity = c.getString(c.getColumnIndex("city"));
           	 vsex = c.getString(c.getColumnIndex("sex"));
           	 
           	 //byIso1 = fpdata;
           	 UserData = vfname+" "+vlname+" "+vdob+" "+vphoneno+" "+vcountry+" "+vnationality+" "+vcity+" "+vsex ;
           	 ImgData = Base64.encodeToString(imgdata, Base64.DEFAULT);
           	 //int age = c.getInt(c.getColumnIndex("Age"));
           	 //results.add("" + firstName + ",Age: " + age);
              	 }while (c.moveToNext());
              }
        }
           	 
       
       
        OnBtnCapture2();
        
              
        
        switch (1) {
        case 1:   byIso1 = fpdata;
        //Toast.makeText(this, "byiso1="+byIso1+" and byiso2="+byIso2+"", Toast.LENGTH_SHORT).show();
           Verify_Result = OnBtnVerifyIso(uId,"1 "+UserData);
        	if(fpmatchsuccess==1)
        	{
        		
        		break;
        	}
                 
        case 2:   byIso1 = fpdata2;
        //Toast.makeText(this, "byiso2="+byIso1+" and byiso2="+byIso2+"", Toast.LENGTH_SHORT).show();
        Verify_Result = OnBtnVerifyIso(uId,"2 "+UserData);
        if(fpmatchsuccess==1)
     	{
     		break;
     	}
        case 3:   byIso1 = fpdata3;
        //Toast.makeText(this, "byiso3="+byIso1+" and byiso2="+byIso2+"", Toast.LENGTH_SHORT).show();
        Verify_Result = OnBtnVerifyIso(uId,"3 "+UserData);
        if(fpmatchsuccess==1)
     	{
     		break;
     	}
        case 4:  byIso1 = fpdata4;
        //Toast.makeText(this, "byiso4="+byIso1+" and byiso2="+byIso2+"", Toast.LENGTH_SHORT).show();
        Verify_Result = OnBtnVerifyIso(uId,"4 "+UserData);
        if(fpmatchsuccess==1)
     	{
     		break;
     	}
        case 5:   byIso1 = fpdata5;
        //Toast.makeText(this, "byiso5="+byIso1+" and byiso2="+byIso2+"", Toast.LENGTH_SHORT).show();
        Verify_Result = OnBtnVerifyIso(uId,"5 "+UserData);
        if(fpmatchsuccess==1)
     	{
     		break;
     	}
        case 6:  byIso1 = fpdata6;
        //Toast.makeText(this, "byiso6="+byIso1+" and byiso2="+byIso2+"", Toast.LENGTH_SHORT).show();
        Verify_Result = OnBtnVerifyIso(uId,"6 "+UserData);
        if(fpmatchsuccess==1)
       	 
     	{
     		break;
     	}
        case 7:   byIso1 = fpdata7;
        //Toast.makeText(this, "byiso7="+byIso1+" and byiso2="+byIso2+"", Toast.LENGTH_SHORT).show();
        Verify_Result = OnBtnVerifyIso(uId,"7 "+UserData);
        if(fpmatchsuccess==1)
     	{
     		break;
     	}
        case 8:   byIso1 = fpdata8;
        //Toast.makeText(this, "byiso8="+byIso1+" and byiso2="+byIso2+"", Toast.LENGTH_SHORT).show();
        Verify_Result = OnBtnVerifyIso(uId,"8 "+UserData);
        if(fpmatchsuccess==1)
     	{
     		
     		break;
     	}
        case 9:  byIso1 = fpdata9;
        //Toast.makeText(this, "byiso9="+byIso1+" and byiso2="+byIso2+"", Toast.LENGTH_SHORT).show();
        Verify_Result = OnBtnVerifyIso(uId,"9 "+UserData);
        if(fpmatchsuccess==1)
     	{
     		
     		break;
     	}
        case 10:  byIso1 = fpdata10;
        //Toast.makeText(this, "byiso10="+byIso1+" and byiso2="+byIso2+"", Toast.LENGTH_SHORT).show();
        Verify_Result = OnBtnVerifyIso(uId,"10 "+UserData);
        if(fpmatchsuccess==1)
     	{
     		
     		break;
     	}
        }
        //Verify_Result = OnBtnVerifyIso(uId,UserData);
        return Verify_Result + " " + ImgData;
   }

    
 public String EditAdminUserInformationCollect(int userID)
 {

   	    flag=0;
   	    String verifyid=Integer.toString(userID);
        Cursor c = db.rawQuery("SELECT * FROM adminuser where adminId='"+verifyid+"'", null);
        String UserData = null;
        String adminId = null;
        String adminUser = null;
        String adminFname = null;
        String adminLname = null; 
        String adminContact = null;
        String adminEmail = null;
        String adminPasswd = null;
       
        if (c != null ) {
        if  (c.moveToFirst()) {
       	 do {
       		 //dId = c.getString(c.getColumnIndex("did")); 
            adminId = c.getString(c.getColumnIndex("adminId"));
            adminPasswd = c.getString(c.getColumnIndex("adminPasswd"));
           	adminUser = c.getString(c.getColumnIndex("adminUser"));
           	adminFname = c.getString(c.getColumnIndex("adminFname"));
           	adminLname = c.getString(c.getColumnIndex("adminLname"));
           	adminContact = c.getString(c.getColumnIndex("adminContact"));
           	adminEmail = c.getString(c.getColumnIndex("adminEmail"));
           	
           	 //byIso1 = fpdata;
           	 UserData = adminId+" "+adminUser+" "+adminPasswd+" "+adminFname+" "+adminLname+" "+adminContact+" "+adminEmail;
           	 
               	 }while (c.moveToNext());
              }
        }
      
    return UserData;
	//return "SELECT uid,fpdata,fpdata2,fpdata3,fpdata4,fpdata5,fpdata6,fpdata7,fpdata8,fpdata9,fpdata10,imgdata FROM emploeeinfo where uid='"+verifyid+"'";
 }
   
 public String EditUserInformationCollect(int userID)
 {

   	 
        String verifyid=Integer.toString(userID);
        Cursor c = db.rawQuery("SELECT * FROM emploeeinfo where uid='"+verifyid+"'", null);
        String UserData = null;
        String ImgData = null;
        byte[] fpdata=null,fpdata2=null,fpdata3=null,fpdata4=null,fpdata5=null,fpdata6=null,fpdata7=null,fpdata8=null,fpdata9=null,fpdata10=null;
        int fpimg = 0;
        int fpimg2 = 0;
        int fpimg3 = 0;
        int fpimg4 = 0;
        int fpimg5 = 0;
        int fpimg6 = 0;
        int fpimg7 = 0;
        int fpimg8 = 0;
        int fpimg9 = 0;
        int fpimg10 = 0;
        
        if (c != null ) {
        if  (c.moveToFirst()) {
       	 do {
       		 //String firstName = c.getString(c.getColumnIndex("FirstName"));
       		 fpdata = c.getBlob(c.getColumnIndex("fpdata"));
       		 fpdata2 = c.getBlob(c.getColumnIndex("fpdata2"));
       		 fpdata3= c.getBlob(c.getColumnIndex("fpdata3"));
       		 fpdata4 = c.getBlob(c.getColumnIndex("fpdata4"));
       		 fpdata5 = c.getBlob(c.getColumnIndex("fpdata5"));
       		 fpdata6 = c.getBlob(c.getColumnIndex("fpdata6"));
       		 fpdata7 = c.getBlob(c.getColumnIndex("fpdata7"));
       		 fpdata8 = c.getBlob(c.getColumnIndex("fpdata8"));
       		 fpdata9 = c.getBlob(c.getColumnIndex("fpdata9"));
       		 fpdata10 = c.getBlob(c.getColumnIndex("fpdata10"));
       		 byte[] imgdata = c.getBlob(c.getColumnIndex("imgdata"));
           	 if(fpdata!=null)
           		fpimg=1;
           	if(fpdata2!=null)
           		fpimg2=1;
           	if(fpdata3!=null)
           		fpimg3=1;
           	if(fpdata4!=null)
           		fpimg4=1;
           	if(fpdata5!=null)
           		fpimg5=1;
           	if(fpdata6!=null)
           		fpimg6=1;
           	if(fpdata7!=null)
           		fpimg7=1;
           	if(fpdata8!=null)
           		fpimg8=1;
           	if(fpdata9!=null)
           		fpimg9=1;
           	if(fpdata10!=null)
           		fpimg10=1;
       		 
           	UserData = fpimg+"##12##"+fpimg2+"##12##"+fpimg3+"##12##"+fpimg4+"##12##"+fpimg5+"##12##"+fpimg6+"##12##"+fpimg7+"##12##"+fpimg8+"##12##"+fpimg9+"##12##"+fpimg10 ;
            ImgData = Base64.encodeToString(imgdata, Base64.DEFAULT);
           	 
              	 }while (c.moveToNext());
              }
        }
      
    return UserData+ "##12##" +ImgData;
 }
    
    public void RunAsRoot() {
        Process p = null;
        Process p1 = null;
        try {
            p = Runtime.getRuntime().exec("su");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       DataOutputStream os = new DataOutputStream(p.getOutputStream());    
        
        try {
            p = Runtime.getRuntime().exec("chmod 777 /dev/bus/usb/001/00*");
        	//p = Runtime.getRuntime().exec("mount -o remount rw /system");
        	
            } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
      //  DataOutputStream os = new DataOutputStream(p.getOutputStream());   
        try {
             os.writeBytes("chmod 777 /dev/bus/usb/001/00*\n");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }  
        try {
            os.flush();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
   
    
    public String OnBtnIdentify()
    {
    	flag=0;
    	OnBtnCapture2();
    	String Identify_result="No Data";
    	Cursor c = db.rawQuery("SELECT uid,fname,lname,fpdata,imgdata FROM emploeeinfo", null);
    	String ImgData = null;
    	
    	if (c != null ) {
    		if  (c.moveToFirst()) {
    			do {
    					byte[] fpdata = c.getBlob(c.getColumnIndex("fpdata"));
    					byte[] imgdata = c.getBlob(c.getColumnIndex("imgdata"));
    					String uId = c.getString(c.getColumnIndex("uid"));
    					String vfname = c.getString(c.getColumnIndex("fname"));
    					String vlname = c.getString(c.getColumnIndex("lname"));
    					String UserData=" Name :"+vfname+" "+vlname; 
    					byIso1 = fpdata;
    					ImgData = Base64.encodeToString(imgdata, Base64.DEFAULT);
    					Identify_result = OnBtnVerifyIso(uId,UserData);
    				}while (c.moveToNext() && flag==0);
           		}
    	}
    	return Identify_result + " " + ImgData; 
    }
    
    
    public String OnBtnCapture1(int fpId) 
    {
    	String msg;
    	String returnVal="";
    	String encoded=null;
    	NBioBSPJNI.FIR_HANDLE hCapturedFIR, hAuditFIR;
    	NBioBSPJNI.CAPTURED_DATA capturedData;
    	Bitmap bmpTemp=null;
    	hCapturedFIR = bsp.new FIR_HANDLE();
    	hAuditFIR = bsp.new FIR_HANDLE();
    	capturedData = bsp.new CAPTURED_DATA();
    	
    	bCapturedFirst = true;
    	
    	//bsp.Capture(hCapturedFIR);
    	bsp.Capture(NBioBSPJNI.FIR_PURPOSE.ENROLL,hCapturedFIR,5000, hAuditFIR, capturedData, Android_Demo.this,0, null);
    	//Toast.makeText(this, "capture called", Toast.LENGTH_SHORT).show();
    	if (bsp.IsErrorOccured())  {
        	msg = "Device is not connected or Capture Error1 : " + bsp.GetErrorCode();
        	returnVal="error";
        }
        else  {
        	NBioBSPJNI.INPUT_FIR inputFIR;
        	
        	inputFIR = bsp.new INPUT_FIR();
        	
        	// Make ISO 19794-2 data
        	{
        		NBioBSPJNI.Export.DATA exportData;
        		
        		inputFIR.SetFIRHandle(hCapturedFIR);
        		
        		exportData = exportEngine.new DATA();
        		
        		exportEngine.ExportFIR(inputFIR, exportData, NBioBSPJNI.EXPORT_MINCONV_TYPE.ISO);
        		
        		
        		if (bsp.IsErrorOccured())  {
            		msg = "NBioBSP ExportFIR Error2: " + bsp.GetErrorCode();
            		returnVal="error";
            		//tvInfo.setText(msg);
            		Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            		return null;
            	}
        		
        		if (byIso1 != null)
        			byIso1 = null;
        		
        		byIso1 = new byte[exportData.FingerData[0].Template[0].Data.length];
        		byIso1 = exportData.FingerData[0].Template[0].Data;
        		
        		switch (fpId) {
                case 11:  fingerprint=byIso1;
                	
                         break;
                case 12:  fingerprint2=byIso1;
               
                         break;
                case 13:  fingerprint3=byIso1;
               
                         break;
                case 14:  fingerprint4=byIso1;
                         break;
                case 15:  fingerprint5=byIso1;
                         break;
                case 16:  fingerprint6=byIso1;
                         break;
                case 17:  fingerprint7=byIso1;
                         break;
                case 18:  fingerprint8=byIso1;
                         break;
                case 19:  fingerprint9=byIso1;
                         break;
                case 20: fingerprint10=byIso1;
                         break;
                default: fingerprint=byIso1;
                         break;
            }
        		
        		
        	}
        	
        	// Make Raw Image data
        	{
        		NBioBSPJNI.Export.AUDIT exportAudit;
        		
        		inputFIR.SetFIRHandle(hAuditFIR);
        		
        		exportAudit = exportEngine.new AUDIT();
        		
        		exportEngine.ExportAudit(inputFIR, exportAudit);
        		
        		//TextView tvInfo = (TextView) findViewById(R.id.textInfo);
        		
        		if (bsp.IsErrorOccured())  {
            		msg = "NBioBSP ExportAudit Error3: " + bsp.GetErrorCode();
            		returnVal="error";
            		//tvInfo.setText(msg);
            		Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            		return null;
            	}
        		
        		if (byCapturedRaw1 != null)
        			byCapturedRaw1 = null;
        		
        		byCapturedRaw1 = new byte[exportAudit.FingerData[0].Template[0].Data.length];
        		byCapturedRaw1 = exportAudit.FingerData[0].Template[0].Data;
        		
        		bmpTemp = Bitmap.createBitmap(exportAudit.ImageWidth, exportAudit.ImageHeight, Bitmap.Config.ARGB_8888);
    			ByteBuffer src = ByteBuffer.allocate(exportAudit.ImageWidth * exportAudit.ImageHeight * 4);
    			byte[] srcbuf = src.array();
    			
    			for (int i = 0; i < byCapturedRaw1.length; i++)  {
    				srcbuf[i * 4] = byCapturedRaw1[i];
    				srcbuf[i * 4 + 1] = byCapturedRaw1[i];
    				srcbuf[i * 4 + 2] = byCapturedRaw1[i];
    				srcbuf[i * 4 + 3] = (byte) 255;
    	        }

    			src.position(0);
    			bmpTemp.copyPixelsFromBuffer(src);
    			
    			ByteArrayOutputStream baos = new ByteArrayOutputStream();  
    			bmpTemp.compress(Bitmap.CompressFormat.PNG, 100, baos);
    			byte[] b = baos.toByteArray();
    			
    			
    			
    			switch (fpId) {
                case 11:  fpimg1 = b;
                         break;
                case 12:  fpimg2= b;
                         break;
                case 13:  fpimg3 = b;
                         break;
                case 14:  fpimg4 = b;
                         break;
                case 15:  fpimg5 = b;
                         break;
                case 16:  fpimg6 = b;
                         break;
                case 17:  fpimg7 = b;
                         break;
                case 18:  fpimg8 = b;
                         break;
                case 19:  fpimg9 = b;
                         break;
                case 20: fpimg10 = b;
                         break;
                default: fpimg1 = b;
                         break;
            }
    			//View vFP = (View) findViewById(R.id.viewFP1);
    			//vFP.setBackgroundDrawable(new BitmapDrawable(bmpTemp));
    			
    			//encoded = Base64.encodeToString(srcbuf, Base64.DEFAULT);
    			
    			msg = "Status :Image Capture Success";
    			//tvInfo.setText(msg);
    			
    		    			
    			nCapturedRawWidth1 = exportAudit.ImageWidth;
    			nCapturedRawHeight1 = exportAudit.ImageHeight;
    			
        	}     	
               	        	
       
    	
    	
    	
    	
    	ByteArrayOutputStream bm = new ByteArrayOutputStream();  
    	bmpTemp.compress(Bitmap.CompressFormat.PNG, 100, bm); //bm is the bitmap object   
    	byte[] b = bm.toByteArray();

    	//to encode base64 from byte array use following method

    	encoded = Base64.encodeToString(b, Base64.DEFAULT);
    	//returnVal=encoded;
    	return encoded;
        }
    	Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    	return returnVal;
    }
    
    
    public void OnBtnCapture2()
    {
    	String msg;
    	
    	NBioBSPJNI.FIR_HANDLE hCapturedFIR, hAuditFIR;
    	NBioBSPJNI.CAPTURED_DATA capturedData;
    	
    	hCapturedFIR = bsp.new FIR_HANDLE();
    	hAuditFIR = bsp.new FIR_HANDLE();
    	capturedData = bsp.new CAPTURED_DATA();
    	
    	bCapturedFirst = false;
    	
    	//bsp.Capture(hCapturedFIR);
    	bsp.Capture(NBioBSPJNI.FIR_PURPOSE.ENROLL,hCapturedFIR,5000, hAuditFIR, capturedData, Android_Demo.this,0, null);

    	if (bsp.IsErrorOccured())  {
        	msg = "NBioBSP Capture Error: " + bsp.GetErrorCode();
        }
        else  {
        	NBioBSPJNI.INPUT_FIR inputFIR;
        	
        	inputFIR = bsp.new INPUT_FIR();
        	
        	// Make ISO 19794-2 data
        	{
        		NBioBSPJNI.Export.DATA exportData;
        		
        		inputFIR.SetFIRHandle(hCapturedFIR);
        		
        		exportData = exportEngine.new DATA();
        		
        		exportEngine.ExportFIR(inputFIR, exportData, NBioBSPJNI.EXPORT_MINCONV_TYPE.ISO);
        		//TextView tvInfo = (TextView) findViewById(R.id.textInfo);
        	        		
        		if (bsp.IsErrorOccured())  {
            		msg = "NBioBSP ExportFIR Error: " + bsp.GetErrorCode();
            		//tvInfo.setText(msg);
            		Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            		return ;
            	}
        		
        		if (byIso2 != null)
        			byIso2 = null;
        		
        		byIso2 = new byte[exportData.FingerData[0].Template[0].Data.length];
        		byIso2 = exportData.FingerData[0].Template[0].Data;
        	}
        	
        	// Make Raw Image data
        	{
        		NBioBSPJNI.Export.AUDIT exportAudit;
        		
        		inputFIR.SetFIRHandle(hAuditFIR);
        		
        		exportAudit = exportEngine.new AUDIT();
        		
        		exportEngine.ExportAudit(inputFIR, exportAudit);
        		
        		//TextView tvInfo = (TextView) findViewById(R.id.textInfo);
        		
        		if (bsp.IsErrorOccured())  {
            		msg = "NBioBSP ExportAudit Error: " + bsp.GetErrorCode();
            		//tvInfo.setText(msg);
            		Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            		return ;
            	}
        		
        		if (byCapturedRaw2 != null)
        			byCapturedRaw2 = null;
        		
        		byCapturedRaw2 = new byte[exportAudit.FingerData[0].Template[0].Data.length];
        		byCapturedRaw2 = exportAudit.FingerData[0].Template[0].Data;
        		
        		Bitmap bmpTemp = Bitmap.createBitmap(exportAudit.ImageWidth, exportAudit.ImageHeight, Bitmap.Config.ARGB_8888);
    			ByteBuffer src = ByteBuffer.allocate(exportAudit.ImageWidth * exportAudit.ImageHeight * 4);
    			byte[] srcbuf = src.array();
    			
    			for (int i = 0; i < byCapturedRaw2.length; i++)  {
    				srcbuf[i * 4] = byCapturedRaw2[i];
    				srcbuf[i * 4 + 1] = byCapturedRaw2[i];
    				srcbuf[i * 4 + 2] = byCapturedRaw2[i];
    				srcbuf[i * 4 + 3] = (byte) 255;
    	        }

    			src.position(0);
    			bmpTemp.copyPixelsFromBuffer(src);
    			
    			//View vFP = (View) findViewById(R.id.viewFP2);
    			//vFP.setBackgroundDrawable(new BitmapDrawable(bmpTemp));
    			
    			msg = "Capture Success";
    		    			
    			nCapturedRawWidth2 = exportAudit.ImageWidth;
    			nCapturedRawHeight2 = exportAudit.ImageHeight;
        	}
        }
    	
    	msg = "Capture Success";
    	//Toast.makeText(this, "byIso2="+byIso2+"", Toast.LENGTH_SHORT).show();
    }
    
    public String OnBtnVerifyIso(String viuid,String vflname)
    {
    	String msg = "Status :";
    	 	
    	if (byIso1 != null && byIso2 != null)  {
    		NBioBSPJNI.FIR_HANDLE hLoadFIR1, hLoadFIR2;
    		// Make First SDK FIR Data
    		{
    			hLoadFIR1 = bsp.new FIR_HANDLE();
    			
    			exportEngine.ImportFIR(byIso1, byIso1.length, NBioBSPJNI.EXPORT_MINCONV_TYPE.ISO, hLoadFIR1);
    			
    			if (bsp.IsErrorOccured())  {
    				msg = "Status :NBioBSP ImportFIR Error: " + bsp.GetErrorCode();
              		Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            		//return ;
    			}
    		}
    		
    		// Make Second SDK FIR Data
    		{
    			hLoadFIR2 = bsp.new FIR_HANDLE();
    			
    			exportEngine.ImportFIR(byIso2, byIso2.length, NBioBSPJNI.EXPORT_MINCONV_TYPE.ISO, hLoadFIR2);
    			
    			if (bsp.IsErrorOccured())  {
    				hLoadFIR1.dispose();
    				msg = "Status :NBioBSP ImportFIR Error: " + bsp.GetErrorCode();
            	//	tvInfo.setText(msg);
            		//Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            		//return ;
    			}
    		}
    		
    		// Verify Match
    		NBioBSPJNI.INPUT_FIR inputFIR1, inputFIR2;
    		Boolean bResult = new Boolean(false);
    		
    		inputFIR1 = bsp.new INPUT_FIR();
    		inputFIR2 = bsp.new INPUT_FIR();
    		
    		inputFIR1.SetFIRHandle(hLoadFIR1);
    		inputFIR2.SetFIRHandle(hLoadFIR2);
    		
    		bsp.VerifyMatch(inputFIR1, inputFIR2, bResult, null);
    		 		
    		if (bsp.IsErrorOccured())  {
    			msg = "Status :NBioBSP VerifyMatch Error: " + bsp.GetErrorCode();
    		}
    		else  {
    			if (bResult)
    				{
    				//msg = "Verify ISO 19794-2 Match Succeed "+viuid;
    				msg = "Succeed##$## "+viuid+" "+vflname;
    			//	editText5.setText(viuid);
    				flag=1;
    				fpmatchsuccess=1;
    				Calendar c = Calendar.getInstance();

    				String sDate = c.get(Calendar.YEAR) + "-" 
    				+ c.get(Calendar.MONTH)
    				+ "-" + c.get(Calendar.DAY_OF_MONTH); 
    				String sTime = c.get(Calendar.HOUR_OF_DAY) 
    				+ ":" + c.get(Calendar.MINUTE)+":"+ c.get(Calendar.SECOND);

    				//Insertlogdata(viuid,sDate,sTime);  // java log store
    				}
    			else
    				{msg = "failed##$##";fpmatchsuccess=0;}
    		}
    		
    		hLoadFIR1.dispose();
    		hLoadFIR2.dispose();
    		
    		//Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    	}
    	else{
    		if(byIso1!=null)
    			Toast.makeText(this, "Can not find captured data", Toast.LENGTH_SHORT).show();
    		
    		fpmatchsuccess=0;
    	}
       
    	//Toast.makeText(this, "byiso1="+byIso1+" and byiso2="+byIso2+"", Toast.LENGTH_SHORT).show();
    	return msg;
        	
       
    }
    //p//
    public void OnBtnVerifyRaw(View target)
    {
    	String msg = "";
    	//TextView tvInfo = (TextView) findViewById(R.id.textInfo);
    	
    	if (byCapturedRaw1 != null && byCapturedRaw2 != null)  {
    		NBioBSPJNI.FIR_HANDLE hLoadAudit1, hLoadAudit2;
    		NBioBSPJNI.FIR_HANDLE hPorcessedFIR1, hPorcessedFIR2; 
    		
    		// Make First SDK FIR Data
    		{
    			NBioBSPJNI.Export.AUDIT importAudit = exportEngine.new AUDIT();
    			
    			importAudit.FingerNum = (byte) 1;
    			importAudit.SamplesPerFinger = 1;
    			importAudit.ImageWidth = nCapturedRawWidth1;
    			importAudit.ImageHeight = nCapturedRawHeight1;
    			importAudit.FingerData = new NBioBSPJNI.Export.FINGER_DATA[importAudit.FingerNum];
    			importAudit.FingerData[0] = exportEngine.new FINGER_DATA();
    			importAudit.FingerData[0].Template = new NBioBSPJNI.Export.TEMPLATE_DATA[importAudit.SamplesPerFinger];
				importAudit.FingerData[0].Template[0] = exportEngine.new TEMPLATE_DATA();
				importAudit.FingerData[0].FingerID = NBioBSPJNI.FINGER_ID.UNKNOWN;
				importAudit.FingerData[0].Template[0].Data = new byte[byCapturedRaw1.length];
				importAudit.FingerData[0].Template[0].Data = byCapturedRaw1;
    			
				hLoadAudit1 = bsp.new FIR_HANDLE();
    			
    			exportEngine.ImportAudit(importAudit, hLoadAudit1);
    			
    			if (bsp.IsErrorOccured())  {
    				msg = "NBioBSP ImportAudit Error: " + bsp.GetErrorCode();
            		//tvInfo.setText(msg);
            		Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            		return ;
    			}
    			
    			NBioBSPJNI.INPUT_FIR inputFIR = bsp.new INPUT_FIR();
    			hPorcessedFIR1 = bsp.new FIR_HANDLE();
    			
    			inputFIR.SetFIRHandle(hLoadAudit1);
    			
    			bsp.Process(inputFIR, hPorcessedFIR1);
    			
    			if (bsp.IsErrorOccured())  {
    				hLoadAudit1.dispose();
    				msg = "NBioBSP Process Error: " + bsp.GetErrorCode();
            		//tvInfo.setText(msg);
            		Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            		return ;
    			}
    		}
    		
    		// Make Second SDK FIR Data
    		{
    			NBioBSPJNI.Export.AUDIT importAudit = exportEngine.new AUDIT();
    			
    			importAudit.FingerNum = (byte) 1;
    			importAudit.SamplesPerFinger = 1;
    			importAudit.ImageWidth = nCapturedRawWidth2;
    			importAudit.ImageHeight = nCapturedRawHeight2;
    			importAudit.FingerData = new NBioBSPJNI.Export.FINGER_DATA[importAudit.FingerNum];
    			importAudit.FingerData[0] = exportEngine.new FINGER_DATA();
    			importAudit.FingerData[0].Template = new NBioBSPJNI.Export.TEMPLATE_DATA[importAudit.SamplesPerFinger];
				importAudit.FingerData[0].Template[0] = exportEngine.new TEMPLATE_DATA();
				importAudit.FingerData[0].FingerID = NBioBSPJNI.FINGER_ID.UNKNOWN;
				importAudit.FingerData[0].Template[0].Data = new byte[byCapturedRaw2.length];
				importAudit.FingerData[0].Template[0].Data = byCapturedRaw2;
    			
				hLoadAudit2 = bsp.new FIR_HANDLE();
    			
    			exportEngine.ImportAudit(importAudit, hLoadAudit2);
    			
    			if (bsp.IsErrorOccured())  {
    				hLoadAudit1.dispose();
    				msg = "NBioBSP ImportAudit Error: " + bsp.GetErrorCode();
            		//tvInfo.setText(msg);
            		Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            		return ;
    			}
    			
    			NBioBSPJNI.INPUT_FIR inputFIR = bsp.new INPUT_FIR();
    			hPorcessedFIR2 = bsp.new FIR_HANDLE();
    			
    			inputFIR.SetFIRHandle(hLoadAudit2);
    			
    			bsp.Process(inputFIR, hPorcessedFIR2);
    			
    			if (bsp.IsErrorOccured())  {
    				hLoadAudit1.dispose();
    				hPorcessedFIR1.dispose();
    				hLoadAudit2.dispose();
    				msg = "NBioBSP Process Error: " + bsp.GetErrorCode();
            		//tvInfo.setText(msg);
            		Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            		return ;
    			}
    		}
    		
    		// Verify Match
    		NBioBSPJNI.INPUT_FIR inputFIR1, inputFIR2;
    		Boolean bResult = new Boolean(false);
    		
    		inputFIR1 = bsp.new INPUT_FIR();
    		inputFIR2 = bsp.new INPUT_FIR();
    		
    		inputFIR1.SetFIRHandle(hPorcessedFIR1);
    		inputFIR2.SetFIRHandle(hPorcessedFIR2);
    		
    		bsp.VerifyMatch(inputFIR1, inputFIR2, bResult, null);
    		 		
    		if (bsp.IsErrorOccured())  {
    			msg = "NBioBSP VerifyMatch Error: " + bsp.GetErrorCode();
    		}
    		else  {
    			if (bResult)
    				msg = "Verify RAW Match succeed";
    			else
    				msg = "Verify RAW Match Failed";
    		}
    		
    		hLoadAudit1.dispose();
    		hLoadAudit2.dispose();
    		hPorcessedFIR1.dispose();
    		hPorcessedFIR2.dispose();
    		
    		Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    	}
    	else
    		Toast.makeText(this, "Can not find captured data", Toast.LENGTH_SHORT).show();
    }
  
   /* public void WriteLogCSV(String log)  // This Code write once in file only ,dose not appen file 
    { 
    	String filename = "logs.csv";
		
    	File file = new File(Environment.getExternalStorageDirectory(), filename);
    	FileOutputStream fos;
    	byte[] data = log.getBytes();
    	try {
    	    fos = new FileOutputStream(file);
    	    fos.write(data,0,data.length);
    	    fos.flush();
    	    //fos.close();
    	} catch (FileNotFoundException e) {
    	    // handle exception
    	} catch (IOException e) {
    	    // handle exception
    	}
    }
    */
    
    public void WriteLogCSV(String log)
    {       
       File logFile = new File("sdcard/LOGS.txt");
       if (!logFile.exists())
       {
          try
          {
             logFile.createNewFile();
          } 
          catch (IOException e)
          {
             // TODO Auto-generated catch block
             e.printStackTrace();
          }
       }
       try
       {
          //BufferedWriter for performance, true to set append to file flag
          BufferedWriter buf = new BufferedWriter(new FileWriter(logFile, true)); 
          buf.append(log);
          buf.newLine();
          buf.close();
       }
       catch (IOException e)
       {
          // TODO Auto-generated catch block
          e.printStackTrace();
       }
    }
    
    public void writeminotia(byte[] log,String minotiafilename)
    {       
       File logFile = new File(minotiafilename+".min");
       if (!logFile.exists())
       {
          try
          {
             logFile.createNewFile();
          } 
          catch (IOException e)
          {
             // TODO Auto-generated catch block
             e.printStackTrace();
          }
       }
       try
       {
          //BufferedWriter for performance, true to set append to file flag
          //BufferedWriter buf = new BufferedWriter(new FileWriter(logFile, true)); 
          //buf.append(log);
          //buf.newLine();
          //buf.close();
    	  
    	   FileOutputStream f = new FileOutputStream(new File(minotiafilename+".min"));
    	   f.write(log);
    	   f.close();
    	   
          
          
          
       }
       catch (IOException e)
       {
          // TODO Auto-generated catch block
          e.printStackTrace();
       }
    }
   
    public String AUResult()
    {
    	return AUResultSTR;
    }
    public void SetStrNODATA()
    {
    	AUResultSTR = "NO_DATA";
    }
    
    public void StopAutoscan()
    {
    	bAutoOn = false;
    }
    
public void StartAutoscan(){
		
    	//sampleDialogFragment.show(getFragmentManager(), "DIALOG_TYPE_STOP");
    	//sampleDialogFragment.setCancelable(false);
    	bAutoOn = true;
		new Thread(new Runnable() {
			
			public void run() {

				while(bAutoOn){
					
					byte[] bFingerExist = new byte[1];
					bFingerExist[0] = 0;
					bsp.CheckFinger(bFingerExist);
					
					if(bFingerExist[0]==1){
						//OnCapture1(1000);
					//AUResultSTR =	OnBtnIdentify();
					OnIdentify(2000);
						
					}
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
				
			}
		}).start();
		
    	
    }
    
public void addFptoIndexSearch()
{
	String msg;
	NBioBSPJNI.FIR_HANDLE hLoadFIR1, hLoadFIR2;
	NBioBSPJNI.INPUT_FIR inputFIR1;
	
	
	hLoadFIR1 = bsp.new FIR_HANDLE();
	inputFIR1 = bsp.new INPUT_FIR();
	
	Cursor c = db.rawQuery("SELECT did,uid,fname,lname,fpdata,imgdata FROM emploeeinfo", null);
    String dId = null;
    String uId = null;
    String vfname = null;
    String vlname = null;
    String UserData = null;
    String ImgData = null;
    if (c != null ) {
    if  (c.moveToFirst()) {
   	 do {
   		 //String firstName = c.getString(c.getColumnIndex("FirstName"));
   		 byte[] fpdata = c.getBlob(c.getColumnIndex("fpdata"));
   		 byte[] imgdata = c.getBlob(c.getColumnIndex("imgdata"));
       	 dId = c.getString(c.getColumnIndex("did")); 
       	 uId = c.getString(c.getColumnIndex("uid"));
       	 vfname = c.getString(c.getColumnIndex("fname"));
       	 vlname = c.getString(c.getColumnIndex("lname"));
       	 byIso1 = fpdata;
       	 
  		
       	OnAddFIR(5000,uId);
       	  }while (c.moveToNext());
          }
    }
	
 }

    

public synchronized void OnAddFIR(int timeout, String id){

	if (byIso1 != null )  {
		NBioBSPJNI.FIR_HANDLE hLoadFIR1;
		// Make First SDK FIR Data
		{
			hLoadFIR1 = bsp.new FIR_HANDLE();
			
			exportEngine.ImportFIR(byIso1, byIso1.length, NBioBSPJNI.EXPORT_MINCONV_TYPE.ISO, hLoadFIR1);
			
			if (bsp.IsErrorOccured())  {
				String msg = "Status :NBioBSP ImportFIR Error: " + bsp.GetErrorCode();
          		Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        		//return ;
			}
		}
		
		// Make Second SDK FIR Data
		
		
		// Verify Match
		NBioBSPJNI.INPUT_FIR inputFIR1;
		Boolean bResult = new Boolean(false);
		
		inputFIR1 = bsp.new INPUT_FIR();
		
		
		inputFIR1.SetFIRHandle(hLoadFIR1);
		
	
	//---------
	//NBioBSPJNI.FIR_HANDLE hCapturedFIR = null, hAuditFIR;
	//NBioBSPJNI.CAPTURED_DATA capturedData;
	///hCapturedFIR = bsp.new FIR_HANDLE();
	//hAuditFIR = bsp.new FIR_HANDLE();
	//capturedData = bsp.new CAPTURED_DATA();
	
	//bsp.Capture(NBioBSPJNI.FIR_PURPOSE.ENROLL,hCapturedFIR,timeout, hAuditFIR, capturedData, this,0,null);

	//exportEngine.ImportFIR(byIso1, byIso1.length, NBioBSPJNI.EXPORT_MINCONV_TYPE.ISO, hCapturedFIR);
	
	//if (bsp.IsErrorOccured())  {
   // 	String msg = "NBioBSP Capture Error: " + bsp.GetErrorCode();
   // }else  {

    //	NBioBSPJNI.INPUT_FIR inputFIR;
    	
    //	inputFIR = bsp.new INPUT_FIR();
    	
    //	inputFIR.SetFIRHandle(hCapturedFIR);

		SAMPLE_INFO sampleInfo = indexSearch.new SAMPLE_INFO();
		
		indexSearch.AddFIR(inputFIR1, Integer.parseInt(id), sampleInfo);
		if (bsp.IsErrorOccured())  {
			
			Toast.makeText(this, id+ " Add Failure", Toast.LENGTH_SHORT).show();
		}else{
			
			Toast.makeText(this, id+ " Add Success", Toast.LENGTH_SHORT).show();
		}

    }

}

public  void OnIdentify(int timeout){
	
	String onidenty_res = "NO_DATA";
	NBioBSPJNI.FIR_HANDLE hCapturedFIR, hAuditFIR;
	NBioBSPJNI.CAPTURED_DATA capturedData;
	hCapturedFIR = bsp.new FIR_HANDLE();
	hAuditFIR = bsp.new FIR_HANDLE();
	capturedData = bsp.new CAPTURED_DATA();
	
	bsp.Capture(NBioBSPJNI.FIR_PURPOSE.ENROLL,hCapturedFIR,timeout, hAuditFIR, capturedData, this,0,null);

	if (bsp.IsErrorOccured())  {
    	String msg = "NBioBSP Capture Error: " + bsp.GetErrorCode();
    }else  {

    	NBioBSPJNI.INPUT_FIR inputFIR;
    	
    	inputFIR = bsp.new INPUT_FIR();
    	
    	inputFIR.SetFIRHandle(hCapturedFIR);

    	FP_INFO fpInfo = indexSearch.new FP_INFO();
		
		indexSearch.Identify(inputFIR, 1, fpInfo, 2000);
		
		if(fpInfo.ID!=0){    			
			//Toast.makeText(this, fpInfo.ID+" Identify Success", Toast.LENGTH_SHORT).show();
			giveImagetoIDENTIFY(fpInfo.ID);
		}else{
			//Toast.makeText(this, "Identify Failure", Toast.LENGTH_SHORT).show();
			AUResultSTR= "Status :Match Failed Match Failed";
		}

    }	
	
}

public void giveImagetoIDENTIFY(int userID)
{
	 
	 String Verify_Result = "No Data";
    String verifyid=Integer.toString(userID);
    Cursor c = db.rawQuery("SELECT did,uid,fname,lname,fpdata,imgdata FROM emploeeinfo where uid='"+verifyid+"'", null);
    String dId = null;
    String uId = null;
    String vfname = null;
    String vlname = null;
    String UserData = null;
    String ImgData = null;
    if (c != null ) {
    if  (c.moveToFirst()) {
   	 do {
   		 //String firstName = c.getString(c.getColumnIndex("FirstName"));
   		 byte[] fpdata = c.getBlob(c.getColumnIndex("fpdata"));
   		 byte[] imgdata = c.getBlob(c.getColumnIndex("imgdata"));
       	 dId = c.getString(c.getColumnIndex("did")); 
       	 uId = c.getString(c.getColumnIndex("uid"));
       	 vfname = c.getString(c.getColumnIndex("fname"));
       	 vlname = c.getString(c.getColumnIndex("lname"));
       	 byIso1 = fpdata;
       	 UserData = dId+" Name :"+vfname+" "+vlname;
       	 ImgData = Base64.encodeToString(imgdata, Base64.DEFAULT);
       	 //int age = c.getInt(c.getColumnIndex("Age"));
       	 //results.add("" + firstName + ",Age: " + age);
          	 }while (c.moveToNext());
          }
    }
    //OnBtnCapture2();
    //Verify_Result = OnBtnVerifyIso(uId,UserData);
    AUResultSTR= "Status :Match Succeed   ID:"+uId+"   "+UserData + " " + ImgData;
}




public synchronized void OnRemoveUser(String id){
	
	indexSearch.RemoveUser(Integer.parseInt(id));
	if (bsp.IsErrorOccured())  {			
		Toast.makeText(this, id+" Delete Failure", Toast.LENGTH_SHORT).show();
	}else{
		
		Toast.makeText(this, id+" Delete Success", Toast.LENGTH_SHORT).show();
	}
	
}

/* (non-Javadoc)
 * @see com.nitgen.SDK.AndroidBSP.UserDialog.UserDialogListener#onClickPositiveBtn(android.app.DialogFragment, java.lang.String)
 */
public void onClickPositiveBtn(DialogFragment dialogFragment, String id) {
	
	
	if("add_fir".equals(dialogFragment.getTag())){
		OnAddFIR(5000, id);
	}else if("remove".equals(dialogFragment.getTag())){
		OnRemoveUser(id);
	}
	
}


public String countMinotia()
{
	String count=null;
	
	byte[] fpdata=null;
	byte[] fpdata2=null;
	byte[] fpdata3=null;
	byte[] fpdata4=null;
	byte[] fpdata5=null;
	byte[] fpdata6=null;
	byte[] fpdata7=null;
	byte[] fpdata8=null;
	byte[] fpdata9=null;
	byte[] fpdata10=null;
	byte[] imgdata=null;
	
	int CountFP=0;
	int countIMG=0;
	 Cursor c = db.rawQuery("SELECT * FROM emploeeinfo", null);
	   
	    if (c != null ) {
	    if  (c.moveToFirst()) {
	   	 do {
	   		 	   		
	   		  fpdata = c.getBlob(c.getColumnIndex("fpdata"));
      		  fpdata2 = c.getBlob(c.getColumnIndex("fpdata2"));
      		  fpdata3= c.getBlob(c.getColumnIndex("fpdata3"));
      		  fpdata4 = c.getBlob(c.getColumnIndex("fpdata4"));
      		  fpdata5 = c.getBlob(c.getColumnIndex("fpdata5"));
      		  fpdata6 = c.getBlob(c.getColumnIndex("fpdata6"));
      		  fpdata7 = c.getBlob(c.getColumnIndex("fpdata7"));
      		  fpdata8 = c.getBlob(c.getColumnIndex("fpdata8"));
      		  fpdata9 = c.getBlob(c.getColumnIndex("fpdata9"));
      		  fpdata10 = c.getBlob(c.getColumnIndex("fpdata10"));
      		  imgdata = c.getBlob(c.getColumnIndex("imgdata"));
      		  
      	    if(fpdata!=null)
      			CountFP=CountFP+1;
      	    if(fpdata2!=null)
      			CountFP=CountFP+1;
      	    if(fpdata3!=null)
      			CountFP=CountFP+1;
      	    if(fpdata4!=null)
      			CountFP=CountFP+1;
      	    if(fpdata5!=null)
      			CountFP=CountFP+1;
      	    if(fpdata6!=null)
      			CountFP=CountFP+1;
      	    if(fpdata7!=null)
      			CountFP=CountFP+1;
      	    if(fpdata8!=null)
      			CountFP=CountFP+1;
      	    if(fpdata9!=null)
      			CountFP=CountFP+1;
      	    if(fpdata10!=null)
      			CountFP=CountFP+1;
      		
      	    if(imgdata!=null)
      			countIMG=countIMG+1;
	       	 
	         }while (c.moveToNext());
	    }
	    
	    } 
	    
	return CountFP+" "+countIMG;
}

public String UserMangement()
{
	//byte[] fpdata=null,fpdata2=null,fpdata3=null,fpdata4=null,fpdata5=null,fpdata6=null,fpdata7=null,fpdata8=null,fpdata9=null,fpdata10=null;
	String Verify_Result = "No Data";
    Cursor c = db.rawQuery("SELECT uid,fname,lname,dob,phoneno,country,nationality,city,sex FROM emploeeinfo", null);
    String dId = null;
    String uId = null;
    String vfname = null;
    String vlname = null;
    String vdob = null; 
    String vphoneno = null;
    String vcountry = null;
    String vnationality = null;
    String vcity = null;
    String vsex = null;
    String UserData = "";
    //String ImgData = null;
    if (c != null ) {
    if  (c.moveToFirst()) {
   	 do {
   		 //String firstName = c.getString(c.getColumnIndex("FirstName"));
   		
       	 uId = c.getString(c.getColumnIndex("uid"));
       	 vfname = c.getString(c.getColumnIndex("fname"));
       	 vlname = c.getString(c.getColumnIndex("lname"));
       	 vdob = c.getString(c.getColumnIndex("dob"));
       	 vphoneno = c.getString(c.getColumnIndex("phoneno"));
       	 vcountry = c.getString(c.getColumnIndex("country"));
       	 vnationality = c.getString(c.getColumnIndex("nationality"));
       	 vcity = c.getString(c.getColumnIndex("city"));
       	 vsex = c.getString(c.getColumnIndex("sex"));
       	 
       	 //byIso1 = fpdata;
       	 UserData = UserData+"<tr><td>" + uId+"</td><td>"+ vfname.replaceAll("\\s","")+" "+vlname.replaceAll("\\s","")+"</td><td class=center>"+vdob+"</td><td class=center>"+vsex+"</td><td class=center>"+vphoneno.replaceAll("\\s","")+"</td><td><a class='btn btn-info' href='#' title='Edit' onClick=EditUser("+uId+",'"+vfname.replaceAll("\\s","")+"','"+vlname.replaceAll("\\s","")+"','"+vdob+"','"+vphoneno.replaceAll("\\s","")+"','"+vcountry.replaceAll("\\s","")+"','"+vnationality.replaceAll("\\s","")+"','"+vcity.replaceAll("\\s","")+"','"+vsex+"') ><i class='icon-edit icon-white'></i></a><a class='btn btn-danger' href='#' title='Delete' onClick='deleteUser("+uId+");'><i class='icon-trash icon-white'></i></a></td></tr>";
       	 //ImgData = Base64.encodeToString(imgdata, Base64.DEFAULT);
       	 //int age = c.getInt(c.getColumnIndex("Age"));
       	 //results.add("" + firstName + ",Age: " + age);
          	 }while (c.moveToNext());
    }
    
    }
return UserData;
}



    public void postData() {
        // Create a new HttpClient and Post Header
    	//smartsuite.bioenabletech.com/demo/attendance_logs_demo.php?value_EquipmentID=1122&value_WorkID=1235&value_Recorddate=2013-07-26&value_Recordtime=12:41:45
        
        try {
            // Add your data
        	HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost("http://smartsuite.bioenabletech.com/demo/attendance_logs_demo.php");

            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(4);
            nameValuePairs.add(new BasicNameValuePair("value_EquipmentID", "12345"));
            nameValuePairs.add(new BasicNameValuePair("value_WorkID", "1235"));
            nameValuePairs.add(new BasicNameValuePair("value_Recorddate", "2013-08-05"));
            nameValuePairs.add(new BasicNameValuePair("value_Recordtime", "10:40:20"));
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

            // Execute HTTP Post Request
            HttpResponse response = httpclient.execute(httppost);
            
        }catch(Exception ex)
    		{
    			
    		}
       // } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
       // } catch (IOException e) {
            // TODO Auto-generated catch block
       // }
    }


	public void OnConnected() {
		// TODO Auto-generated method stub
		if(sampleDialogFragment!=null)
			sampleDialogFragment.dismiss();
		rval = 1;
		String message = "Device Open Success";
	}


	public void OnDisConnected() {
		// TODO Auto-generated method stub
		NBioBSPJNI.CURRENT_PRODUCT_ID = 0;
		
		if(sampleDialogFragment!=null)
			sampleDialogFragment.dismiss();
		rval = 0;
		String message = "NBioBSP Disconnected: " + bsp.GetErrorCode();
	
	} 
    
}




