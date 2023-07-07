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

    init() {
        AF
            .request("https://lively-ganache-1b6917.netlify.app/cyberpunk.json")
            .responseDecodable(of: SwiftCyberList.self) { response in
            guard let data = response.value else { return };
            data.cyberpunk_works.forEach { work in
                self.works.append(work);
            }
        }
    }
}
