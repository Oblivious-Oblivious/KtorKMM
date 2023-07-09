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
    @Published var library = "";

    init() {
        AF
            .request("https://cyberpunk-data-host.dreamnotexpiring.com/")
            .responseDecodable(of: SwiftCyberList.self) { response in
            guard let data = response.value else { return };
            data.cyberpunk_works.forEach { work in
                self.works.append(work);
            }
        }
        self.library = "Alamofire";
    }
}
