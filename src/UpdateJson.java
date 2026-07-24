import org.json.JSONArray;
import org.json.JSONObject;

public class UpdateJson {

	public static void main(String[] args) {

		String jsonPayload = """
								{
				  "orderId": "O1001",
				  "orderDate": "2025-05-10",
				  "customer": {
				    "name": "Bob Johnson",
				    "address": {
				      "street": "123 Maple Street",
				      "city": "Anytown",
				      "state": "CA",
				      "zip": "90210"
				    },
				    "contact": {
				      "email": "bob.j@example.com",
				      "phone": "555-4567"
				    }
				  },
				  "items": [
				    {
				      "productId": "P001",
				      "productName": "Laptop",
				      "quantity": 2,
				      "price": 999.99
				    },
				    {
				      "productId": "P003",
				      "productName": "Keyboard",
				      "quantity": 1,
				      "price": 75.50
				    }
				  ],
				  "associatedProblems": [
				    {
				      "problemName": "Diabetes",
				      "medications": [
				        {
				          "medicationName": "Aspirin",
				          "dose": "500 mg"
				        },
				        {
				          "medicationName": "Metformin",
				          "dose": "850 mg"
				        }
				      ]
				    }
				  ],
				  "status": "pending"
				}
								""";
		
		JSONObject jsonObject = new JSONObject(jsonPayload);
		JSONArray itemArray = jsonObject.getJSONArray("items");
		
		//1st method to read and manipulate JSON using Java 
		
//		System.out.println(itemArray.getJSONObject(0).toString(2));   
//		itemArray.getJSONObject(0).put("productName", "Desktop");
//		
//		System.out.println(itemArray.getJSONObject(0).toString(2));
		
		
		//2nd method to read JSON using Java 
		
		for(int index=0; index<itemArray.length(); index++)
		{
			JSONObject item = itemArray.getJSONObject(index);
			
			if(item.getString("productName").equalsIgnoreCase("Laptop")) {
				item.put("productName", "Desktop");
			}
		}
		
		System.out.println(itemArray.getJSONObject(0).toString(2));
		
	//	System.out.println(jsonObject.toString(2));

	}

}
