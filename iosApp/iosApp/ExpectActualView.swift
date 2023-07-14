//
//  ExpectActualView.swift
//  iosApp
//
//  Created by Papapostolou, Athanasios on 13/07/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI;
import shared;

struct ExpectActualView: View {
    var body: some View {
        VStack {
            Text("class: \(PlatformClass().name())")
                .padding(8);
            Text("function: \(CommonDataModel.companion.platformFunctionCommon())")
                .padding(8);
            Text("property: \(CommonDataModel.companion.platformPropertyCommon)")
                .padding(8);
            Text("object: \(CommonDataModel.companion.platformObjectCommon.name)")
                .padding(8);
            Text("enum: \(CommonDataModel.companion.direction(direction: .south))")
                .padding(8);
        }
    }
}
