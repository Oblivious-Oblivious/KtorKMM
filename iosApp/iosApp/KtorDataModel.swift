//
//  KtorDataModel.swift
//  iosApp
//
//  Created by Thanasis Papapostolou on 05/07/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI;
import shared;

class KtorDataModel: ObservableObject {
    @Published var works: [CyberWork] = [];
    @Published var library = "Ktor";

    init() {
        JsonGetter().get_json { data, error in
            if let cyberlist = data {
                DispatchQueue.main.async {
                    self.works = cyberlist.works;
                }
            }
            else {
                let err = error?.localizedDescription ?? "error";
                self.works = [CyberWork(name: err, creator: err, year: err)];
            }
        }
    }
}
