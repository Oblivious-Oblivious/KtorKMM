import SwiftUI;
import shared;
import Alamofire;

struct ContentView: View {
//    @ObservedObject var viewmodel: AlamofireDataModel;
    @ObservedObject var viewmodel: KtorDataModel;

    var body: some View {
        Text("Works in \(viewmodel.library)")
            .padding(8);
        List {
            ForEach(viewmodel.works, id: \.self) { work in
                Text("\(work.name) (\(work.year)), \(work.creator)");
            }
        }
	}
}
