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
    @Published var library = "Alamofire";

    init() {
        AF
            .request("https://cyberpunk-data-host.dreamnotexpiring.com/")
            .responseDecodable(of: SwiftCyberList.self) { response in
                if let data = response.value {
                    DispatchQueue.main.async {
                        self.works = data.works;
                    }
                }
                else {
                    let err = response.error?.localizedDescription ?? "error";
                    self.works = [SwiftCyberWork(name: err, creator: err, year: err)];
                }
            }
    }
}
