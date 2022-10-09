package WhitePhoenix.utils;

import WhitePhoenix.pojos.create_payment.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class JsonBodyCreator {

    static JSONObject
            test_case;

    public JsonBodyCreator(String testSuite, String testCase) {
        selectDataObject(testCase, testSuite);
    }


    public static String fetchDataFile(String testSuite) {
        StringBuffer jsonTxt = new StringBuffer();
        String filepath = System.getProperty("user.dir") + "\\src\\main\\java\\WhitePhoenix\\resources\\data\\"+testSuite+".json";
        try {
            File file = new File(filepath);
            InputStream inputStream = Files.newInputStream(file.toPath(), StandardOpenOption.READ);
            InputStreamReader reader = new InputStreamReader(inputStream);
            BufferedReader lineReader = new BufferedReader(reader);
            String line;
            while ((line = lineReader.readLine()) != null) {
                jsonTxt.append(line).append("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonTxt.toString();
    }

//    public static JSONObject fetchDataFile(String testSuite) throws IOException {
//        String filepath = System.getProperty("user.dir") + "\\src\\main\\java\\WhitePhoenix\\resources\\data\\"+testSuite+".json";
//        JSONObject jsonObject = new JSONObject(Files.readAllBytes(Paths.get(filepath)));
//        return jsonObject;
//    }

    public void selectDataObject(String testCase,String testSuite)
    {
            JSONObject json = new JSONObject(fetchDataFile(testSuite));
            JSONArray testCases = json.getJSONArray("test_cases");
            for(int i=0; i<testCases.length(); i++)
            {
                test_case = testCases.getJSONObject(i);
                if(test_case.get("test_case").equals(testCase))
                {
                    break;
                }
            }
    }


    public CreatePaymentRequest createJsonBody()
    {

        Redirect_Urls redirectUrls = new Redirect_Urls();
        redirectUrls.setCancel_url(test_case.get("cancel_url").toString());
        redirectUrls.setReturn_url(test_case.get("return_url").toString());

        Payer payer = new Payer();
        payer.setPayment_method(test_case.get("payment_method").toString());

        PaymentOptions options = new PaymentOptions();
        options.setAllowed_payment_method(test_case.get("allowed_payment_method").toString());

        Transaction_Details details = new Transaction_Details();
        details.setSubtotal(test_case.get("subtotal").toString());
        details.setTax(test_case.get("tax").toString());
        details.setHandling_fee(test_case.get("handling_fee").toString());
        details.setInsurance(test_case.get("insurance").toString());
        details.setShipping(test_case.get("shipping").toString());
        details.setShipping_discount(test_case.get("shipping_discount").toString());

        Transaction_Amount amount  = new Transaction_Amount();
        amount.setTotal(test_case.get("total").toString());
        amount.setCurrency(test_case.get("currency").toString());
        amount.setDetails(details);

        Items item1 = new Items();
        item1.setCurrency(test_case.get("currency").toString());
        item1.setDescription(test_case.get("description").toString());
        item1.setName(test_case.get("name").toString());
        item1.setPrice(test_case.get("price").toString());
        item1.setQuantity(test_case.get("quantity").toString());
        item1.setSku(test_case.get("sku").toString());
        item1.setTax(test_case.get("item_tax").toString());

        Items item2 = new Items();
        item2.setCurrency(test_case.get("currency").toString());
        item2.setDescription(test_case.get("description1").toString());
        item2.setName(test_case.get("name1").toString());
        item2.setPrice(test_case.get("price1").toString());
        item2.setQuantity(test_case.get("quantity1").toString());
        item2.setSku(test_case.get("sku1").toString());
        item2.setTax(test_case.get("item_tax1").toString());

        ShippingAddress address = new ShippingAddress();
        address.setCity(test_case.get("city").toString());
        address.setCountry_code(test_case.get("country_code").toString());
        address.setLine1(test_case.get("line1").toString());
        address.setLine2(test_case.get("line2").toString());
        address.setPhone(test_case.get("phone").toString());
        address.setPostal_code(test_case.get("postal_code").toString());
        address.setRecipient_name(test_case.get("recipient_name").toString());
        address.setState(test_case.get("state").toString());

        List<Items> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);

        Item_List item_list = new Item_List();
        item_list.setItems(items);
        item_list.setShipping_address(address);

        Transactions transactions = new Transactions();
        transactions.setAmount(amount);
        transactions.setCustom(test_case.get("custom").toString());
        transactions.setDescription(test_case.get("description").toString());
        transactions.setInvoice_number(test_case.get("invoice_number").toString());
        transactions.setItem_list(item_list);
        transactions.setPayment_options(options);
        transactions.setSoft_descriptor(test_case.get("soft_descriptor").toString());

        List<Transactions> list = new ArrayList<>();
        list.add(transactions);


        CreatePaymentRequest createPaymentRequest = new CreatePaymentRequest();
        createPaymentRequest.setIntent(test_case.get("intent").toString());
        createPaymentRequest.setNote_to_payer(test_case.get("note_to_payer").toString());
        createPaymentRequest.setPayer(payer);
        createPaymentRequest.setTransactions(list);
        createPaymentRequest.setRedirect_urls(redirectUrls);

        return createPaymentRequest;


    }
}
