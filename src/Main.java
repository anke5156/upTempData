import hyx.com.util.CommonUtil;
import hyx.com.util.ConnDB;
import hyx.com.util.RadomUtil;

import java.sql.SQLException;

/***创造大棚伪数据
 *
 */
public class Main {

    public static void main(String[] args) {
        String sql = "insert into tb_mrgh_data_acquisition " +
                "(idno,mushroom_pointid,mushroom_airtemp,mushroom_airhumidity,mushroom_soiltemp,mushroom_soilmoisture,mushroom_ightintensity,mushroom_co2densuty,memo,ctime) " +
                "values(?,?,?,?,?,?,?,?,?,?)";

        System.out.println("前方高能!!!");

        int cn = 1;

        while (true) {

            String idno = String.valueOf(1000+cn);
            String pointid = RadomUtil.toFixdLengthString(Long.parseLong(RadomUtil.getRandom1(0,38)),5);//大棚编号
            String airtemp = RadomUtil.getRandom3(0,38,2);//大气温度
            String airhumidity = RadomUtil.getRandom3(10,50,2);//空气湿度
            String soiltemp = RadomUtil.getRandom3(0,38,2);//土壤温度
            String soilmoisture = RadomUtil.getRandom3(10,50,2) ;//土壤湿度
            String ightintensity = RadomUtil.getRandom3(10,50,2);//光照轻度
            String co2densuty = RadomUtil.getRandom3(10,50,2);//二氧化碳浓度
            String memo = "";//备注
            String ctime = CommonUtil.getLocalSysTime2();

            try {
                ConnDB.insert(sql, idno,pointid,airtemp,airhumidity,soiltemp,soilmoisture,ightintensity,co2densuty,memo,ctime);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cn++;
        }
    }
}
