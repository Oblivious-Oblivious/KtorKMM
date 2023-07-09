import SwiftUI

@main
struct iOSApp: App {
	var body: some Scene {
		WindowGroup {
            ContentView(datamodel: AlamofireDataModel());
//            ContentView(datamodel: KtorDataModel());
		}
	}
}
