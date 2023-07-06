//
//  SwiftCyberWork.swift
//  iosApp
//
//  Created by Thanasis Papapostolou on 06/07/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation;

struct SwiftCyberList: Decodable {
    var cyberpunk_works: [SwiftCyberWork];
    
    enum CodingKeys: String, CodingKey {
        case cyberpunk_works = "cyberpunk_works";
    }
}

struct SwiftCyberWork: Decodable, Hashable {
    let name: String;
    let creator: String;
    let year: String;
    
    enum CodingKeys: String, CodingKey {
        case name = "name";
        case creator = "creator";
        case year = "year";
    }
}
