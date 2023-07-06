//
//  AlamofireDataModel.swift
//  iosApp
//
//  Created by Thanasis Papapostolou on 06/07/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI;
import Alamofire;

class AlamofireDataModel: ObservableObject {
    @Published var works: [SwiftCyberWork] = [];
    
    func get_json() {
        AF
            .request("http://127.0.0.1:8080/cyberpunk.json")
            .responseDecodable(of: SwiftCyberList.self) { response in
            guard let data = response.value else { return };
            data.cyberpunk_works.forEach { work in
                self.works.append(work);
            }
        }
    }

    init() {
        get_json();
    }
}
