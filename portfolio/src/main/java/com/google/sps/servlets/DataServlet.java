// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.servlets;

import java.io.IOException;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Servlet that returns some example content. TODO: modify this file to handle comments data */
@WebServlet("/data")
public class DataServlet extends HttpServlet {

private ArrayList<String> names;

  @Override
  public void init() {
      names = new ArrayList<String>();
      names.add("RMP");
      names.add("Love Me More");
      names.add("6 Kiss");
      names.add("Abandoned");
      names.add("Real Feel");
      names.add("Chosen");
      names.add("Can you Rap Like Me -Pt.2");

      
  }
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
      
  //Convert the strings to JSON
 String json = convertToJsonUsingGson(names);
//Send response as JSON
    response.setContentType("application/json;");
    response.getWriter().println(json);
    
  }
 
   private String convertToJson(ArrayList<String> names) {
    String json = "{";
    json += "\"Trippie Songs 0\": ";
    json += "\"" + names.get(0) + "\"";
    json += ", ";
    json += "\"Trippie Songs 1\": ";
    json += "\"" + names.get(1) + "\"";
    json += ", ";
    json += "\"Trippie Songs 2\": ";
    json += names.get(2);
    json += ", ";
    json += "\"Trippie Songs 3\": ";
    json += names.get(3);
    json += "}";
    return json;
  }
  private String convertToJsonUsingGson(ArrayList<String> names) {
    Gson gson = new Gson();
    String json = gson.toJson( names);
    return json;
  }

    
}
