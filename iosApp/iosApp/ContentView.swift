import SwiftUI;
import shared;
import Alamofire;

struct ContentView: View {
    @ObservedObject var datamodel: AlamofireDataModel;
//    @ObservedObject var datamodel: KtorDataModel;

    var body: some View {
        Text("Works in \(datamodel.library)")
            .padding(8);
        List {
            ForEach(datamodel.works, id: \.self) { work in
                Text("\(work.name) (\(work.year)), \(work.creator)");
            }
        }
	}
}
