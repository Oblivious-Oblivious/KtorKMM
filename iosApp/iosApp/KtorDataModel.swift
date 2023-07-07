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

    init() {
        JsonGetter().get_json { data, error in
            if let cyberlist = data {
                cyberlist.cyberpunk_works.forEach { work in
                    self.works.append(work);
                }
            }
            else {
                let nullsafe_error = error?.localizedDescription ?? "error";
                self.works.append(CyberWork(name: nullsafe_error, creator: nullsafe_error, year: nullsafe_error));
            }
        }
    }
}
