package learn;

/**
 * @author: xiaolong
 * @Date: 上午12:44 2018/8/29
 * @Description:  进程调度算法
 */
public class ProcessDispatch {

    /***
     *
     *
     * 进程调度算法
     * 在系统中，用户进程数一般都多于处理机数、这将导致它们互相争夺处理机。另外，系统进程也同样需要使用处理机。这就要求进程调度程序按一定的策略，动态地把处理机分配给处于就绪队列中的某一个进程，以使之执行。
     *
     * 进程调度任务
     *
     * （1）首先保存当前进程的处理机的现场信息
     *
     * （2）按照算法选取进程
     *
     * （3）把处理器分配给进程。（将选中进程的进程控制块内有关处理机现场现场的信息装入处理机相应寄存器中，进程控制处理机，使之从上次的断点处恢复运行）
     *
     * 一、先来先服务和短作业(进程)优先调度算法
     * 1.先来先服务调度算法
     *     按照作业提交或进程变为就绪状态的先后次序，分派CPU；
     *
     * 　　当前作业或进程占用CPU，直到执行完或阻塞，才出让CPU（非抢占方式）。
     *
     * 　　在作业或进程唤醒后（如I/O完成），并不立即恢复执行，通常等到当前作业或进程出让CPU。
     *
     *     》适用场景：
     *
     * 　　比较有利于长作业，而不利于短作业。因为长作业会长时间占据处理机。
     *
     * 　　有利于CPU繁忙的作业，而不利于I/O繁忙的作业。
     *
     * 2．短作业(进程)优先调度算法
     * 短作业(进程)优先调度算法SJ(P)F，是指对短作业或短进程优先调度的算法。它们可以分别用于作业调度和进程调度。短作业优先(SJF)的调度算法是从后备队列中选择一个或若干个估计运行时间最短的作业，将它们调入内存运行。而短进程优先(SPF)调度算法则是从就绪队列中选出一个估计运行时间最短的进程，将处理机分配给它，使它立即执行并一直执行到完成，或发生某事件而被阻塞放弃处理机时再重新调度。主要的不足之处是长作业的运行得不到保证
     *
     * 二、高优先权优先调度算法
     * 1.优先权调度算法的类型
     *
     * 为了照顾紧迫型作业，使之在进入系统后便获得优先处理，引入了最高优先权优先(FPF)调度算法。此算法常被用于批处理系统中，作为作业调度算法，也作为多种操作中的进程调度算法，还可用于实时系统中。当把该算法用于作业调度时，系统将从后备队列中选择若干个优先权最高的作业装入内存。当用于进程调度时，该算法是把处理机分配给就绪队列中优先权最高的进程，这时，又可进一步把该算法分成如下两种。
     *
     * 1) 非抢占式优先权算法
     *
     * 在这种方式下，系统一旦把处理机分配给就绪队列中优先权最高的进程后，该进程便一直执行下去，直至完成；或因发生某事件使该进程放弃处理机时，系统方可再将处理机重新分配给另一优先权最高的进程。这种调度算法主要用于批处理系统中；也可用于某些对实时性要求不严的实时系统中。
     *
     * 2) 抢占式优先权调度算法
     *
     * 在这种方式下，系统同样是把处理机分配给优先权最高的进程，使之执行。但在其执行期间，只要又出现了另一个其优先权更高的进程，进程调度程序就立即停止当前进程(原优先权最高的进程)的执行，重新将处理机分配给新到的优先权最高的进程。因此，在采用这种调度算法时，是每当系统中出现一个新的就绪进程i 时，就将其优先权Pi与正在执行的进程j 的优先权Pj进行比较。如果Pi≤Pj，原进程Pj便继续执行；但如果是Pi>Pj，则立即停止Pj的执行，做进程切换，使i 进程投入执行。显然，这种抢占式的优先权调度算法能更好地满足紧迫作业的要求，故而常用于要求比较严格的实时系统中，以及对性能要求较高的批处理和分时系统中。
     *
     * 2．高响应比优先调度算法
     *
     * 在批处理系统中，短作业优先算法是一种比较好的算法，其主要的不足之处是长作业的运行得不到保证。如果我们能为每个作业引入前面所述的动态优先权，并使作业的优先级随着等待时间的增加而以速率a 提高，则长作业在等待一定的时间后，必然有机会分配到处理机。该优先权的变化规律可描述为：
     * 操作系统
     * 由于等待时间与服务时间之和就是系统对该作业的响应时间，故该优先权又相当于响应比RP。据此，又可表示为：
     * 操作系统
     * 由上式可以看出：
     *
     * (1) 如果作业的等待时间相同，则要求服务的时间愈短，其优先权愈高，因而该算法有利于短作业。
     *
     * (2) 当要求服务的时间相同时，作业的优先权决定于其等待时间，等待时间愈长，其优先权愈高，因而它实现的是先来先服务。
     *
     * 三、基于时间片的轮转调度算法
     *
     * 1.轮转（round robin。RR）调度算法
     * 在分时系统中，最简单最常用的是时间片的轮转调度算法，该算法采用了非常公平的处理机分配方式，即让就绪队列上的每个进程仅运行一个时间片。
     *
     * >轮转法的基本原理
     *
     * 系统将所有就绪进程按FCFS策略排成就绪队列。系统每隔一段时间产生一次间断，去激活进程调度程序进行调度，把CPU分配给队首进程，并令其执行一个时间片
     *
     * 若一个时间片还未用完，进程便已完成就立即激活调度程序，将他从就绪队列中删除。
     *
     * 若一个时间片用完，计时器中断处理程序被激活，调度程序将它送往就绪队列末尾。
     *
     * 》时间片长度的确定：
     * 　　时间片长度变化的影响
     *
     * 　　过长－>退化为FCFS算法，进程在一个时间片内都执行完，响应时间长。
     *
     * 　　过短－>用户的一次请求需要多个时间片才能处理完，上下文切换次数增加，响应时间长。
     *
     *       一个较为可取的时间片的大小是略大于一次典型的交互所需时间，是大多数交互程序能在一个时间片内完成。
     *
     * 　　对响应时间的要求：T(响应时间)=N(进程数目)*q(时间片)
     *
     * 　　就绪进程的数目：数目越多，时间片越小
     *
     * 　　系统的处理能力：应当使用户输入通常在一个时间片内能处理完，否则使响应时间，平均周转时间和平均带权周转时间延长。
     *
     * 2．多级反馈队列调度算法
     * 前面介绍的各种用作进程调度的算法都有一定的局限性。如短进程优先的调度算法，仅照顾了短进程而忽略了长进程，而且如果并未指明进程的长度，则短进程优先和基于进程长度的抢占式调度算法都将无法使用。而多级反馈队列调度算法则不必事先知道各种进程所需的执行时间，而且还可以满足各种类型进程的需要，因而它是目前被公认的一种较好的进程调度算法。在采用多级反馈队列调度算法的系统中，调度算法的过程如下所述。
     *
     * (1) 应设置多个就绪队列，并为各个队列赋予不同的优先级。第一个队列的优先级最高，第二个队列次之，其余各队列的优先权逐个降低。该算法赋予各个队列中进程执行时间片的大小也各不相同，在优先权愈高的队列中，为每个进程所规定的执行时间片就愈小。例如，第二个队列的时间片要比第一个队列的时间片长一倍，……，第i+1个队列的时间片要比第i个队列的时间片长一倍。
     *
     * (2) 当一个新进程进入内存后，首先将它放入第一队列的末尾，按FCFS原则排队等待调度。当轮到该进程执行时，如它能在该时间片内完成，便可准备撤离系统；如果它在一个时间片结束时尚未完成，调度程序便将该进程转入第二队列的末尾，再同样地按FCFS原则等待调度执行；如果它在第二队列中运行一个时间片后仍未完成，再依次将它放入第三队列，……，如此下去，当一个长作业(进程)从第一队列依次降到第n队列后，在第n 队列便采取按时间片轮转的方式运行。
     *
     * (3) 仅当第一队列空闲时，调度程序才调度第二队列中的进程运行；仅当第1～(i-1)队列均空时，才会调度第i队列中的进程运行。如果处理机正在第i队列中为某进程服务时，又有新进程进入优先权较高的队列(第1～(i-1)中的任何一个队列)，则此时新进程将抢占正在运行进程的处理机，即由调度程序把正在运行的进程放回到第i队列的末尾，把处理机分配给新到的高优先权进程。
     *
     * 优点：
     * 　　为提高系统吞吐量和缩短平均周转时间而照顾短进程。
     *
     * 　　为获得较好的I/O设备利用率和缩短响应时间而照顾I/O型进程。
     *
     * 　　不必估计进程的执行时间，动态调节
     */
}
