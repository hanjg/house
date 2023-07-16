import com.github.sh0nk.matplotlib4j.Plot;
import com.github.sh0nk.matplotlib4j.PythonConfig;
import java.util.Arrays;

/**
 * @author anxi
 * @version 2022/12/7 20:40
 */
public class PlotTest {

    public static void main(String[] args) throws Exception {
        Plot plt = Plot.create(PythonConfig.pythonBinPathConfig("D:\\python3.6\\python.exe"));
        plt.plot()
                .add(Arrays.asList(1.3, 2))
                .label("label")
                .linestyle("--");
        plt.xlabel("xlabel");
        plt.ylabel("ylabel");
        plt.text(0.5, 0.2, "text");
        plt.title("Title!");
        plt.legend();
        plt.show();
    }
}
